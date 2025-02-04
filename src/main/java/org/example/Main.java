package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Benchmark bench = new Benchmark(1_000, 100_000);
//        bench.runBenchmark();

        int size = 100_000;
        long startTime, stopTime;
        ArrayHandler handler = new ArrayHandler(size);
        handler.shuffleArray();
        PairFinder finder = new PairFinder(handler.getArray(), 225227, size);
        startTime = System.nanoTime();
        finder.findClosestPair();
        stopTime = System.nanoTime();
        long runTimeNano = stopTime - startTime;
//        finder.printResult(result);
        System.out.println("Runtime is: " + (float) runTimeNano / 1_000_000 + "ms");
    }

}