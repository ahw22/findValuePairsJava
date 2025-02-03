package org.example;

import java.util.*;

public class PairFinder {

    int[] array;
    int target;
    HashMap<Integer, List<int[]>> pairMap = new HashMap<>();

    public PairFinder(int[] array, int target) {
        this.array = Arrays.stream(array).sorted().toArray();
        this.target = target;
    }


    public int[] findClosestPair() {
        int[] result;
        long startTime = System.nanoTime();
        createPairs(target, array, pairMap);

        if (pairMap.isEmpty()) {
            return null;
        }
        if (pairMap.size() == 1) {
            result = pairMap.get(0).getFirst();
        } else {
            int shortestDistance = Collections.min(pairMap.keySet());
//            result = findLargestDifference(pairMap, shortestDistance);
            result = pairMap.get(shortestDistance).getFirst();
        }
        long stopTime = System.nanoTime();
        System.out.println("Runtime: " + (float) (stopTime - startTime) / 1000000 + "ms");
//        printResult(result);
        return result;
    }

    private void printResult(int[] result) {
        if (result == null) {
            System.out.println("There is no pair!");
            System.out.println("-".repeat(80));
        }

        System.out.println("The solution is: " + Arrays.toString(result));
        System.out.println("Difference is: " + Math.abs(result[0] - result[1]));
        System.out.println("-".repeat(80));
    }

    private int[] findLargestDifference(HashMap<Integer, List<int[]>> pairMap, int shortestDistance) {
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

    private void createPairs(int target, int[] array, HashMap<Integer, List<int[]>> pairMap) {
        int indexClosestToTarget = findValueClosestToTarget(array, target, 0, array.length - 1);
        createPairsFromIndex(indexClosestToTarget, array, target, pairMap);
    }

    private void createPairsFromIndex(int indexClosestToTarget, int[] array, int target, HashMap<Integer, List<int[]>> pairMap) {
        if (indexNotEndOfArray(indexClosestToTarget, array))
            indexClosestToTarget++;
        for (int i = indexClosestToTarget; i > 0; i--) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j])
                    continue;
                int distance = Math.abs(target - (array[i] + array[j]));
                if (array[i] + array[j] == target) {
                    //System.out.println("Found pair with 0 distance");
                    addToMap(pairMap, distance, new int[]{array[j], array[i]});
                    return;
                } else {
                    addToMap(pairMap, distance, new int[]{array[j], array[i]});
                }

            }
        }
        addToMap(pairMap, Math.abs(target - (array[indexClosestToTarget] + array[0])), new int[]{array[indexClosestToTarget], array[0]});

    }

    private boolean indexNotEndOfArray(int indexClosestToTarget, int[] array) {
        return indexClosestToTarget < array.length - 1;
    }

    private void addToMap(HashMap<Integer, List<int[]>> pairMap, int distance, int[] ints) {
        if (ints[0] == ints[1]) return;
        List<int[]> tempList = pairMap.get(distance);
        if (tempList == null)
            tempList = new ArrayList<>();
        tempList.add(ints);
        pairMap.put(distance, tempList);
    }


    private int findValueClosestToTarget(int[] array, int target, int start, int end) {
        int halfwayPoint = start + ((end - start) / 2);


        if (start == halfwayPoint) {
            return end;
        }

        if (halfwayPoint == array.length) {
            return halfwayPoint;
        }


        int diff1 = Math.abs(array[halfwayPoint] - target);
        int diff2 = Math.abs(array[halfwayPoint + 1] - target);
        if (diff1 == diff2) {
            return halfwayPoint;
        }
        if (diff1 == 0) {
            return halfwayPoint;
        }
        if (diff2 == 0) {
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
