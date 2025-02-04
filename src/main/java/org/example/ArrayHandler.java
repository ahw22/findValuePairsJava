package org.example;

import java.util.Arrays;
import java.util.Random;

public class ArrayHandler {
    int[] array;


    public ArrayHandler(int size) {
        this.array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i]= i;
        }
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
    }

    //Fisher Yates Shuffle
    public void shuffleArray() {
        Random r = new Random();
        for (int i = array.length-1; i > 0; i--) {
            int target = r.nextInt(i);
            if (target == i) continue;
            int tmp = array[target];
            array[target] = array[i];
            array[i] = tmp;
        }
    }

    public int[] getArray() {
        return array;
    }
}
