package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {23, 14, 16, 5, 31, 1, 49, 17, 6, 3, 7, 29, 10, 44, 8, 21, 25, 15, 33, 34};
        int[] array2 = {14, 42, 34, 11, 19, 39, 21, 50, 29, 7, 48, 17, 16, 35, 38, 4, 40, 10, 31, 8};
        int[] array3 = {46, 45, 30, 23, 35, 43, 37, 15, 28, 32, 10, 24, 1, 19, 25, 49, 6, 9, 40, 18};
        int[] array4 = {36, 8, 16, 27, 37, 26, 30, 43, 48, 50, 35, 49, 32, 31, 20, 38, 23, 13, 5, 42};
        int[] array5 = {15, 28, 47, 12, 3, 45, 24, 44, 23, 6, 20, 16, 30, 40, 42, 17, 10, 25, 32, 36};
        int[] testArray1 = {10, 30, 20, 5};
        int[] testArray2 = {5, 2, 7, 1, 4};
        int[] testArray3 = {10};
        /*
        findClosestPair(array1, 50);
        findClosestPair(array2, 23);
        findClosestPair(array3, 23);
        findClosestPair(array4, 23);
        findClosestPair(array5, 23);

        findClosestPair(testArray1, 25);
        findClosestPair(testArray2, 10);
        findClosestPair(testArray3, 10);

         */
        int[] array = UniqueRandomArray.fillUniqueRandomArray();
        long startTime = System.nanoTime();
        findClosestPair(array, 50000);
        findClosestPair(array1, 50);
        findClosestPair(array2, 23);
        findClosestPair(array3, 23);
        findClosestPair(array4, 23);
        findClosestPair(array5, 23);
        findClosestPair(testArray1, 25);
        findClosestPair(testArray2, 10);
        findClosestPair(testArray3, 10);
        long stopTime = System.nanoTime();
        System.out.println("Runtime: " + (float) (stopTime - startTime) / 1000000 + "ms");

    }

    private static void findClosestPair(int[] array, int target) {
        HashMap<Integer, int[]> pairMap = new HashMap<>();
        array = Arrays.stream(array).sorted().toArray();
        createPairs(target, array, pairMap);

        if (pairMap.isEmpty()) {
            System.out.println("There is no pair!");
            System.out.println("-".repeat(80));
            return;
        }

        int shortestDistance = Collections.min(pairMap.keySet());
        System.out.println("Shortest Distance: " + shortestDistance);
        int[] output = pairMap.get(shortestDistance);
        System.out.println("The solution is: " + Arrays.toString(output));
        System.out.println("Difference is: " + Math.abs(output[0] - output[1]));
        System.out.println("-".repeat(80));
    }

    private static void createPairs(int target, int[] array, HashMap<Integer, int[]> pairMap) {
        System.out.println("Calculating Pairs for array: " + Arrays.toString(array));
        System.out.println("Target is : " + target);
        int indexClosestToTarget = findValueClosestToTarget(array, target);
        System.out.println("Index closest to target: " + indexClosestToTarget + " , value of: " + array[indexClosestToTarget]);
        createPairsFromIndex(indexClosestToTarget, array, target, pairMap);
    }

    private static void createPairsFromIndex(int indexClosestToTarget, int[] array, int target, HashMap<Integer, int[]> pairMap) {
        if (indexClosestToTarget < array.length-1)
            indexClosestToTarget++;
        for (int i = indexClosestToTarget; i > 0; i--) {
            for (int j = 0; j < array.length; j++) {
                int distance = Math.abs(target - array[i] - array[j]);
                if (array[i] + array[j] == target) {
                    //System.out.println("Found pair with 0 distance");
                    pairMap.put(distance, new int[] {array[j], array[i]});
                    return;
                } else if (array[i] + array[j] > array[indexClosestToTarget]) {
                    //System.out.println("Pair larger than target");
                    break;
                } else {
                    pairMap.put(distance, new int[] {array[j], array[i]});
                }

            }
        }

    }

    private static int findValueClosestToTarget(int[] array, int target) {
        if (array.length == 1)
            return 0;
        int halfwayPoint = (array.length / 2);
        int[] part1 = new int[halfwayPoint];
        int[] part2 = new int[halfwayPoint];
        System.arraycopy(array, 0, part1, 0, halfwayPoint);
        System.arraycopy(array, halfwayPoint, part2, 0, halfwayPoint);
        /*
        System.out.println(Arrays.toString(part1));
        System.out.println(Arrays.toString(part2));
        System.out.println("-".repeat(50));
        */
        int diff1 = Math.abs(part1[part1.length-1] - target);
        int diff2 = Math.abs(part2[0] - target);
        if (diff1 == diff2) {
            return halfwayPoint;
        }
        if (diff1 == 0) {
            System.out.println("Diff1 = 0");
            return part1.length - 1;
        }
        if (diff2 == 0) {
            System.out.println("Diff2 = 0");
            return halfwayPoint;
        }
        if (diff1 < diff2) {
            int index = findValueClosestToTarget(part1, target);
            return index;
        } else {
            int index = findValueClosestToTarget(part2, target);
            return halfwayPoint + index;
        }
    }

}