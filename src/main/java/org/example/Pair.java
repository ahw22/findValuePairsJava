package org.example;


import java.util.Arrays;

public class Pair {
    private Integer[] values;
    private int distance;
    private int difference;


    public int getDifference() {
        return difference;
    }

    public Pair(Integer[] values, int distance, int difference) {
        this.values = values;
        this.distance = distance;
        this.difference = difference;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "values=" + Arrays.toString(values) +
                ", distance=" + distance +
                ", difference=" + difference +
                '}';
    }

}
