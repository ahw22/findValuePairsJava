package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class findclosestPair {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testFindClosestPair_array1() {
        int[] array1 = {23, 14, 16, 5, 31, 1, 49, 17, 6, 3, 7, 29, 10, 44, 8, 21, 25, 15, 33, 34};
        int[] result = Main.findClosestPair(array1, 50);

        assertEquals(Arrays.toString(new int[]{1,49}), Arrays.toString(result));
    }
    @Test
    void testFindClosestPair_array2() {
        int[] array = {14, 42, 34, 11, 19, 39, 21, 50, 29, 7, 48, 17, 16, 35, 38, 4, 40, 10, 31, 8};
        int[] result = Main.findClosestPair(array, 23);

        assertEquals(Arrays.toString(new int[]{4,19}), Arrays.toString(result));
    }
    @Test
    void testFindClosestPair_array3() {
        int[] array = {46, 45, 30, 23, 35, 43, 37, 15, 28, 32, 10, 24, 1, 19, 25, 49, 6, 9, 40, 18};
        int[] result = Main.findClosestPair(array, 23);

        assertEquals(Arrays.toString(new int[]{1,23}), Arrays.toString(result));
    }

    @Test
    void testFindClosestPair_array4() {
        int[] array = {36, 8, 16, 27, 37, 26, 30, 43, 48, 50, 35, 49, 32, 31, 20, 38, 23, 13, 5, 42};
        int[] result = Main.findClosestPair(array, 23);

        assertEquals(Arrays.toString(new int[]{8,16}), Arrays.toString(result));
    }

    @Test
    void testFindClosestPair_array5() {
        int[] array = {15, 28, 47, 12, 3, 45, 24, 44, 23, 6, 20, 16, 30, 40, 42, 17, 10, 25, 32, 36};
        int[] result = Main.findClosestPair(array, 23);

        assertEquals(Arrays.toString(new int[]{3,20}), Arrays.toString(result));
    }

    @Test
    void testFindClosestPair_array6() {
        int[] array = {10, 30, 20, 5};
        int[] result = Main.findClosestPair(array, 25);

        assertEquals(Arrays.toString(new int[]{5,20}), Arrays.toString(result));
    }

    @Test
    void testFindClosestPair_array7() {
        int[] array = {5, 2, 7, 1, 4};
        int[] result = Main.findClosestPair(array, 10);

        assertEquals(Arrays.toString(new int[]{2,7}), Arrays.toString(result));
    }

    @Test
    void testFindClosestPair_noPairs() {
        int[] array = {10};
        int[] result = Main.findClosestPair(array, 10);

        assertEquals(null, result);
    }

    @Test
    void testFindClosestPair_10kSeed123() {
        int[] array = UniqueRandomArray.fillUniqueRandomArray(123, 10000);
        int[] result = Main.findClosestPair(array, 8550);

        assertEquals(Arrays.toString(new int[]{40,8510}), Arrays.toString(result));
    }

    @Test
    void testFindClosestPair_10kSeed123_large() {
        int[] array = UniqueRandomArray.fillUniqueRandomArray(123, 10000);
        int[] result = Main.findClosestPair(array, 75650);

        assertEquals(Arrays.toString(new int[]{41,75609}), Arrays.toString(result));
    }

    @Test
    void testFindClosestPair_10kSeed123_small() {
        int[] array = UniqueRandomArray.fillUniqueRandomArray(123, 10000);
        int[] result = Main.findClosestPair(array, 56);

        assertEquals(Arrays.toString(new int[]{0,68}), Arrays.toString(result));
    }

    @Test
    void testFindClosestPair_fromFile() {
        int[] array = ReadArrayFromFile.readFile();
        int[] result = Main.findClosestPair(array, 50);

        assertEquals(Arrays.toString(new int[]{1,49}), Arrays.toString(result));
    }
}