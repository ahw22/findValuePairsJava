package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = {23, 14, 16, 5, 31, 1, 49, 17, 6, 3, 7, 29, 10, 44, 8, 21, 25, 15, 33, 34};
        Integer[] array2 = {14, 42, 34, 11, 19, 39, 21, 50, 29, 7, 48, 17, 16, 35, 38, 4, 40, 10, 31, 8};
        /*
        Integer[] array3 = {46, 45, 30, 23, 35, 43, 37, 15, 28, 32, 10, 24, 1, 19, 25, 49, 6, 9, 40, 18};
        Integer[] array4 = {36, 8, 16, 27, 37, 26, 30, 43, 48, 50, 35, 49, 32, 31, 20, 38, 23, 13, 5, 42};
        Integer[] array5 = {15, 28, 47, 12, 3, 45, 24, 44, 23, 6, 20, 16, 30, 40, 42, 17, 10, 25, 32, 36};
        Integer[] testArray1 = {10, 30, 20, 5};
        Integer[] testArray2 = {5, 2, 7, 1, 4};
        Integer[] testArray3 = {10};
j       */
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
        Integer[] targetArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        long startTime = System.nanoTime();
        findClosestPair(targetArray, 50000);
        findClosestPair(array1, 30);
        findClosestPair(array2, 30);
        long stopTime = System.nanoTime();
        System.out.println("Runtime: " + (float) (stopTime - startTime) / 1000000 + "ms");

    }

    private static void findClosestPair(Integer[] array, int target) {
        HashMap<Integer, List<Pair>> pairMap = new HashMap<>();
        List<Integer> list = Arrays.stream(array)
                .sorted()
                .toList();

        createPairs(target, list, pairMap);

        if (pairMap.isEmpty()) {
            System.out.println("There is no pair!");
            return;
        }

        Integer shortestDistance = Collections.min(pairMap.keySet());
        System.out.println("Shortest Distance: " + shortestDistance);
        Pair output = findLargestDifference(pairMap.get(shortestDistance));
        System.out.println("The solution is: " + output);
        System.out.println("-".repeat(80));
    }

    private static Pair findLargestDifference(List<Pair> pairs) {
        System.out.println(pairs);
        return pairs.stream()
                .max(Comparator.comparingInt(Pair::getDifference))
                .get();
    }

    private static void createPairs(int target, List<Integer> list, HashMap<Integer, List<Pair>> pairMap) {
        System.out.println("Calculating Pairs for List: " + list);
        System.out.println("Target is : " + target);
        int indexClosestToTarget = findValueClosestToTarget(list, target);
        System.out.println("Index closest to target: " + indexClosestToTarget + " , value of: " + list.get(indexClosestToTarget));
    }

    private static int findValueClosestToTarget(List<Integer> list, int target) {
        if (list.size() == 1)
            return 0;
        int halfwayPoint = (list.size() / 2);
        List<Integer> list1 = list.subList(0, halfwayPoint);
        List<Integer> list2 = list.subList(halfwayPoint, list.size());
        int diff1 = Math.abs(list1.getLast() - target);
        int diff2 = Math.abs(list2.getFirst() - target);
        if (diff1 == diff2) {
            return halfwayPoint;
        }
        if (diff1 == 0) {
            System.out.println("Diff1 = 0");
            return list1.size() - 1;
        }
        if (diff2 == 0) {
            System.out.println("Diff2 = 0");
            return halfwayPoint;
        }
        if (diff1 < diff2) {
            int index = findValueClosestToTarget(list1, target);
            return index;
        } else {
            int index = findValueClosestToTarget(list2, target);
            return halfwayPoint + index;
        }
    }

    private static void addPairToMap(HashMap<Integer, List<Pair>> pairMap, int distance, Pair pair) {
        List<Pair> matches = pairMap.get(distance);
        if (matches == null) {
            matches = new ArrayList<>();
        }
        matches.add(pair);
        pairMap.put(distance, matches);
    }
}