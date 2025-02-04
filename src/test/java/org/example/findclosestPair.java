package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class findclosestPair {
    private int arraySize = 100_000;
    private ArrayHandler handler = new ArrayHandler(arraySize);

    @BeforeEach
    void setUp() {
        handler.shuffleArray();
    }

    @Test
    void targetOf1() {
        PairFinder finder = new PairFinder(handler.getArray(), 1, arraySize);
        int[] result = finder.findClosestPair();
        assertEquals(Arrays.toString(new int[]{0,1}), Arrays.toString(result));
    }

    @Test
    void targetOfArraySizeMinus1() {
        PairFinder finder = new PairFinder(handler.getArray(), arraySize-1, arraySize);
        int[] result = finder.findClosestPair();
        assertEquals(Arrays.toString(new int[]{0,arraySize-1}), Arrays.toString(result));
    }
    @Test
    void targetOfArraySize() {
        PairFinder finder = new PairFinder(handler.getArray(), arraySize, arraySize);
        int[] result = finder.findClosestPair();
        assertEquals(Arrays.toString(new int[]{1,arraySize-1}), Arrays.toString(result));
    }
    @Test
    void targetLargerThanArraySize() {
        PairFinder finder = new PairFinder(handler.getArray(), arraySize + 50_000, arraySize);
        int[] result = finder.findClosestPair();
        assertEquals(Arrays.toString(new int[]{50001,arraySize-1}), Arrays.toString(result));
    }
    @Test
    void targetDoubleArraySize() {
        PairFinder finder = new PairFinder(handler.getArray(), arraySize*2, arraySize);
        int[] result = finder.findClosestPair();
        assertEquals(Arrays.toString(new int[]{99998,arraySize-1}), Arrays.toString(result));
    }
    @Test
    void target250k() {
        PairFinder finder = new PairFinder(handler.getArray(), 250_000, arraySize);
        int[] result = finder.findClosestPair();
        assertEquals(Arrays.toString(new int[]{99998,arraySize-1}), Arrays.toString(result));
    }
}
