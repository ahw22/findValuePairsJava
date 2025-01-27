package org.example;

// Java implementation
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueRandomArray {
    public static int[] fillUniqueRandomArray(int seed, int size) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random(seed);

        while (uniqueNumbers.size() < size) {
            int randomValue = random.nextInt(size * 10);
            uniqueNumbers.add(randomValue);
        }

        int[] resultArray = new int[size];
        int i = 0;
        for (int num : uniqueNumbers) {
            resultArray[i++] = num;
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[] uniqueArray = fillUniqueRandomArray(123,10000);
        for (int num : uniqueArray) {
            System.out.println(num);
        }
    }
}