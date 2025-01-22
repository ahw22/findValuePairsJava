package org.example;

// Java implementation
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueRandomArray {
    public static int[] fillUniqueRandomArray() {
        int size = 10000;
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

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
        int[] uniqueArray = fillUniqueRandomArray();
        for (int num : uniqueArray) {
            System.out.println(num);
        }
    }
}