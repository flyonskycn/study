package com.flyonsky.sentinel;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 滑动时间窗限流样例
 * 新建一个本地缓存，每5s为一个时间窗口，每1s为一个时间片段，时间片段作为缓存的key，
 * 原子类计数器作为缓存的value。每秒发送随机数量的请求，计算每个时间片段的前5秒内的累加请求数量，
 * 超出阈值则限流。
 * @author luowengang
 * @date 2020/8/9 11:40
 */
@Slf4j
public class WindowLimiter {
    /** 时间范围 **/
    private final static long TIME_RANGE = 5L;
    /** 关闭应用等待的时间 **/
    private final static long SHUT_DOWN_WAIT_TIME = 60;
    /** 本地计数缓存 **/
    private LoadingCache<Long, AtomicLong> counter =
            // 缓存存保存两个限流时间周期
            CacheBuilder.newBuilder()
                    .expireAfterWrite(TIME_RANGE*2, TimeUnit.SECONDS)
                    .build(new CacheLoader<Long, AtomicLong>() {
                        @Override
                        public AtomicLong load(Long seconds) throws Exception {
                            return new AtomicLong(0);
                        }
                    });

    /** 线程池 **/
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    /** 限流阈值 **/
    private long limit = 15;

    /**
     * 滑动时间窗口
     * 每隔1s累加前5s内每1s的请求数量，判断是否超出限流阈值
     */
    public void slideWindow() {
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                long time = System.currentTimeMillis() / 1000;
                //每秒发送随机数量的请求
                int reqs = (int) (Math.random() * limit/3) + 1;
                counter.get(time).addAndGet(reqs);
                long nums = 0;
                // 5秒内的总流量
                for (int i = 0; i < TIME_RANGE; i++) {
                    nums += counter.get(time - i).get();
                }
                log.info("time=" + time + ",nums=" + nums);

                if (nums > limit) {
                    log.info("限流了,nums=" + nums);
                }
            } catch (Exception e) {
                log.error("slideWindow error", e);
            } finally {

            }
        }, 5000, 1000, TimeUnit.MILLISECONDS);
    }

    /**
     * 关闭
     */
    public void shutDown(){
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                try {
                    // 等待未完成任务结束
                    if (!scheduledExecutorService.awaitTermination(SHUT_DOWN_WAIT_TIME, TimeUnit.SECONDS)) {
                        // 取消当前执行的任务
                        scheduledExecutorService.shutdownNow();
                        log.warn("Interrupt the worker, which may cause some task inconsistent. Please check the biz logs.");

                        // 等待任务取消的响应
                        if (!scheduledExecutorService.awaitTermination(SHUT_DOWN_WAIT_TIME, TimeUnit.SECONDS)){
                            log.error("Thread pool can't be shutdown even with interrupting worker threads, which may cause some task inconsistent. Please check the biz logs.");
                        }
                    }
                } catch (InterruptedException ie) {
                    // 重新取消当前线程进行中断
                    scheduledExecutorService.shutdownNow();
                    log.error("The current server thread is interrupted when it is trying to stop the worker threads. This may leave an inconcistent state. Please check the biz logs.");

                    // 保留中断状态
                    Thread.currentThread().interrupt();
                }
                log.info("Finally shutdown the thead pool");
            }
        });
    }
}
