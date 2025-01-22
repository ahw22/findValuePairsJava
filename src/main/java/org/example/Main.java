package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Integer[] array1 = {23, 14, 16, 5, 31, 1, 49, 17, 6, 3, 7, 29, 10, 44, 8, 21, 25, 15, 33, 34};
        Integer[] array2 = {14, 42, 34, 11, 19, 39, 21, 50, 29, 7, 48, 17, 16, 35, 38, 4, 40, 10, 31, 8};
        Integer[] array3 = {46, 45, 30, 23, 35, 43, 37, 15, 28, 32, 10, 24, 1, 19, 25, 49, 6, 9, 40, 18};
        Integer[] array4 = {36, 8, 16, 27, 37, 26, 30, 43, 48, 50, 35, 49, 32, 31, 20, 38, 23, 13, 5, 42};
        Integer[] array5 = {15, 28, 47, 12, 3, 45, 24, 44, 23, 6, 20, 16, 30, 40, 42, 17, 10, 25, 32, 36};
        Integer[] testArray1 = {10, 30, 20, 5};
        Integer[] testArray2 = {5, 2, 7, 1, 4};
        Integer[] testArray3 = {10};


        findClosestPair(array1, 50);
        findClosestPair(array2, 23);
        findClosestPair(array3, 23);
        findClosestPair(array4, 23);
        findClosestPair(array5, 23);

        findClosestPair(testArray1, 25);
        findClosestPair(testArray2, 10);
        findClosestPair(testArray3, 10);
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
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) continue;
                int distance = Math.abs(list.get(i) + list.get(j) - target);
                int difference = Math.abs(list.get(i) - list.get(j));
                Pair pair = new Pair(new Integer[]{list.get(i), list.get(j)}, distance, difference);
                addPairToMap(pairMap, distance, pair);
            }
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