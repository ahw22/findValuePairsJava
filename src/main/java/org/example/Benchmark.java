package org.example;

import java.util.Arrays;
import java.util.Random;

public class Benchmark {
    private int numOfRuns;
    private int size;
    private long runTimeNano = 0;


    public Benchmark(int numOfRuns, int size) {
        this.numOfRuns = numOfRuns;
        this.size = size;
    }

    public void runBenchmark() {
        Random r = new Random();
        ArrayHandler handler = new ArrayHandler(size);
        for (int i = 0; i < numOfRuns; i++) {
            handler.shuffleArray();
            long startTime, stopTime;
            int target = r.nextInt(25000);
            PairFinder finder = new PairFinder(handler.getArray(), target, size);
            startTime = System.nanoTime();
            int[] result = finder.findClosestPair();
            stopTime = System.nanoTime();
            runTimeNano += stopTime - startTime;
        }
        getAverageRuntime();
    }

    private void getAverageRuntime() {
        float averageRunTimeMili = (float) (runTimeNano / numOfRuns) / 1_000_000;
        System.out.println("The average runtime from " + numOfRuns + " runs is: " + averageRunTimeMili + "ms");
    }
}
