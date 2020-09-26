package com.flyonsky.guava;

import com.google.common.base.Ticker;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author luowengang
 * @date 2020/9/26 21:24
 */
public class CacheTest {

    @Test
    public void testEviction() throws ExecutionException {
        TestTicker testTicker = new TestTicker();
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .expireAfterWrite(1, TimeUnit.DAYS)
                .ticker(testTicker)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return UUID.randomUUID().toString();
                    }
                });
        loadingCache.put("a", "b");

        System.out.println(loadingCache.get("a"));

        // 模拟时间流逝
        testTicker.addElapsedTime(TimeUnit.NANOSECONDS.convert(1, TimeUnit.DAYS));

        System.out.println(loadingCache.get("a"));
    }

    public static class TestTicker extends Ticker {
        private long start = Ticker.systemTicker().read();
        private long elapsedNano = 0;

        @Override
        public long read() {
            return start + elapsedNano;
        }

        public void addElapsedTime(long elapsedNano) {
            this.elapsedNano = elapsedNano;
        }
    }
}
