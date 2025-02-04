package org.example;

import java.util.*;

public class PairFinder {

    int[] array;
    int target;
    int arraySize;

    public PairFinder(int[] array, int target, int arraySize) {
        this.array = array;
        this.target = target;
        this.arraySize = arraySize;
    }


    public int[] findClosestPair() {
        array = Arrays.stream(array).sorted().toArray();
        int[] result = createPair();
        return result;
    }

    private int[] createPair() {
        if (target < arraySize) {
            return new int[]{array[0], array[target]};
        }
        int diff = target - (arraySize-1);
//        System.out.println(diff);
        if (diff < arraySize-1) {
            return new int[]{array[diff], array[arraySize-1]};
        } else {
            return new int[]{array[arraySize-2], array[arraySize-1]};
        }
    }

    public void printResult(int[] result) {
        if (result == null) {
            System.out.println("There is no pair!");
            System.out.println("-".repeat(80));
            return;
        }

        System.out.println("The solution is: " + Arrays.toString(result));
        System.out.println("Difference is: " + Math.abs(result[0] - result[1]));
        System.out.println("-".repeat(80));
    }








}
