package com.flyonsky.jmh;

import org.openjdk.jmh.annotations.*;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/**
 * 一个完整的基准测试用例
 * @author luowengang
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@Warmup(iterations = 5,time = 1)
@Measurement(iterations = 5,time = 1)
public class FirstCustomBenchmark {

    @Param({"1", "31", "65", "101", "103"})
    public int arg;

    @Param({"0", "1", "2", "4", "8", "16", "32"})
    public int certainty;

    @Benchmark
    public boolean bench() {
        return BigInteger.valueOf(arg).isProbablePrime(certainty);
    }
}
