package com.flyonsky.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

/**
 * @author luowengang
 * @date 2021/9/16
 */
public class JsonOutPutBenchmark {
    @Benchmark
    public void wellHelloThere() {
        // this method was intentionally left blank.
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JsonOutPutBenchmark.class.getSimpleName())
                .result(System.currentTimeMillis() + ".json")
                .resultFormat(ResultFormatType.JSON)
                .warmupIterations(1)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(5)
                .measurementTime(TimeValue.seconds(1))
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
