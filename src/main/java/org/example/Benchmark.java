package org.example;

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
        int[] array = UniqueRandomArray.fillUniqueRandomArray(100, size);
        for (int i = 0; i < numOfRuns; i++) {
            Random r = new Random();
            long startTime, stopTime;
            int target = r.nextInt(25000);
            PairFinder finder = new PairFinder(array, target);
            startTime = System.nanoTime();
            finder.findClosestPair();
            stopTime = System.nanoTime();
            runTimeNano += stopTime - startTime;
        }
        getAverageRuntime();
    }

    private void getAverageRuntime() {
        float averageRunTimeMili = (float) (runTimeNano / numOfRuns) / 1000000;
        System.out.println("The average runtime from " + numOfRuns + " is: " + averageRunTimeMili + " ms");
    }
}
