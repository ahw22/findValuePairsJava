package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] array = UniqueRandomArray.fillUniqueRandomArray(123, 100000);
        int[] tmpArray = ReadArrayFromFile.readFile();
        long startTime = System.nanoTime();
//        int[] result = findClosestPair(array, 50000);
        int[] result = findClosestPair(tmpArray, 50);

        printResult(result);

        long stopTime = System.nanoTime();
        System.out.println("Runtime: " + (float) (stopTime - startTime) / 1000000 + "ms");

    }

    private static void printResult(int[] result) {
        if (result == null) {
            System.out.println("There is no pair!");
            System.out.println("-".repeat(80));
        }

        System.out.println("The solution is: " + Arrays.toString(result));
        System.out.println("Difference is: " + Math.abs(result[0] - result[1]));
        System.out.println("-".repeat(80));
    }

    public static int[] findClosestPair(int[] array, int target) {
        HashMap<Integer, List<int[]>> pairMap = new HashMap<>();
        array = Arrays.stream(array).sorted().toArray();
        createPairs(target, array, pairMap);

        if (pairMap.isEmpty()) {

            return null;
        }

        int shortestDistance = Collections.min(pairMap.keySet());
        System.out.println("Shortest Distance: " + shortestDistance);
        return findLargestDifference(pairMap, shortestDistance);

    }

    private static int[] findLargestDifference(HashMap<Integer, List<int[]>> pairMap, int shortestDistance) {
        List<int[]> tempList = pairMap.get(shortestDistance);
        int indexOfMaxDifference = Integer.MIN_VALUE;
        int maxDifference = Integer.MIN_VALUE;
        for (int i = 0; i < tempList.size(); i++) {
            int[] tempArr = tempList.get(i);
            int difference = Math.abs(tempArr[0] - tempArr[1]);
            if (difference > maxDifference) {
                maxDifference = difference;
                indexOfMaxDifference = i;

            }
        }
        return tempList.get(indexOfMaxDifference);
    }

    private static void createPairs(int target, int[] array, HashMap<Integer, List<int[]>> pairMap) {
//        System.out.println("Calculating Pairs for array: " + Arrays.toString(array));
        System.out.println("Target is : " + target);
        int indexClosestToTarget = findValueClosestToTarget(array, target, 0, array.length-1);
        System.out.println("Index closest to target: " + indexClosestToTarget + " , value of: " + array[indexClosestToTarget]);
        createPairsFromIndex(indexClosestToTarget, array, target, pairMap);
    }

    private static void createPairsFromIndex(int indexClosestToTarget, int[] array, int target, HashMap<Integer, List<int[]>> pairMap) {
        if (indexNotEndOfArray(indexClosestToTarget, array))
            indexClosestToTarget++;
        for (int i = indexClosestToTarget; i > 0; i--) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j])
                    continue;
                int distance = Math.abs(target - (array[i] + array[j]));
                if (array[i] + array[j] == target) {
                    //System.out.println("Found pair with 0 distance");
                    addToMap(pairMap, distance, new int[] {array[j], array[i]});
                    return;
                }  else {
                    addToMap(pairMap, distance, new int[] {array[j], array[i]});
                }

            }
        }
        addToMap(pairMap, Math.abs(target - (array[indexClosestToTarget] + array[0])), new int[] {array[indexClosestToTarget], array[0]});

    }

    private static boolean indexNotEndOfArray(int indexClosestToTarget, int[] array) {
        return indexClosestToTarget < array.length - 1;
    }

    private static void addToMap(HashMap<Integer, List<int[]>> pairMap, int distance, int[] ints) {
        if (ints[0] == ints[1]) return;
        List<int[]> tempList = pairMap.get(distance);
        if (tempList == null)
            tempList = new ArrayList<>();
        tempList.add(ints);
        pairMap.put(distance, tempList);
    }


    private static int findValueClosestToTarget(int[] array, int target, int start, int end) {
        int halfwayPoint = start + ((end - start) / 2);

//        System.out.println("Start: " + start);
//        System.out.println("Halfwaypoint: " + halfwayPoint);
//        System.out.println("End: " + end);

        if (start == halfwayPoint) {
//            System.out.println("Returning end: " + end);
            return end;
        }

        if (halfwayPoint == array.length) {
//            System.out.println("Returning halfwaypoint" + halfwayPoint);
            return halfwayPoint;
        }


//        int[] part1 = Arrays.copyOfRange(array, start, halfwayPoint);
//        int[] part2 = Arrays.copyOfRange(array, halfwayPoint, end+ 1);
//
//        System.out.println(Arrays.toString(part1));
//        System.out.println(Arrays.toString(part2));
//        System.out.println("-".repeat(50));

        int diff1 = Math.abs(array[halfwayPoint] - target);
        int diff2 = Math.abs(array[halfwayPoint+ 1] - target);
        if (diff1 == diff2) {
            return halfwayPoint;
        }
        if (diff1 == 0) {
            //System.out.println("Diff1 = 0");
            return halfwayPoint;
        }
        if (diff2 == 0) {
            //System.out.println("Diff2 = 0");
            return halfwayPoint + 1;
        }
        if (diff1 < diff2) {
            int index = findValueClosestToTarget(array, target, start, halfwayPoint);
            return index;
        } else {
            int index = findValueClosestToTarget(array, target, halfwayPoint, end);
            return index;
        }
    }

}