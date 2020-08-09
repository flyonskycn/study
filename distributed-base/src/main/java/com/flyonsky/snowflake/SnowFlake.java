package com.flyonsky.snowflake;

/**
 * 雪花算法实现
 * @author luowengang
 * @date 2020/8/9 9:02
 */
public class SnowFlake {
    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1480166465631L;

    /**
     * 每一部分占用的位数
     */
    /** 序列号占用的位数 **/
    private final static long SEQUENCE_BIT = 12;
    /** 机器标识占用的位数 **/
    private final static long MACHINE_BIT = 5;
    /** 数据中心占用的位数 **/
    private final static long DATACENTER_BIT = 5;

    /**
     * 每一部分的最大值
     */
    /** 数据中心最大值 **/
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    /** 机器标识最大值 **/
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    /** 序列号最大值 **/
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    /** 机器标识向左移动的位数 **/
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    /** 数据中心标识向左移动的位数 **/
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    /** 时间标识向左移动的位数 **/
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    /** 数据中心 **/
    private long datacenterId;
    /** 机器标识 **/
    private long machineId;
    /** 序列号 **/
    private long sequence = 0L;
    /** 上一次时间戳 **/
    private long lastStmp = -1L;

    public SnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     * @return ID值
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                // 获取一个毫秒
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        // 新的id
        return (currStmp - START_STMP) << TIMESTMP_LEFT
                | datacenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    /**
     * 获取下一毫秒
     * @return 与ID生成最后的毫秒的下一毫秒
     */
    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    /**
     * 获取当前毫秒
     * @return 当前毫秒数
     */
    private long getNewstmp() {
        return System.currentTimeMillis();
    }
}
