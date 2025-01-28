package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadArrayFromFile {

    private static final String COMMA_DELIMITER = ",";

    public static int[] readFile() {
        Scanner sc = getScanner();
        List<Integer> tmpList = new ArrayList<>();
        sc.useDelimiter(",");
        return getInts(sc, tmpList);
    }

    private static int[] getInts(Scanner sc, List<Integer> tmpList) {
        while (sc.hasNext()) {
            tmpList.add(Integer.parseInt(sc.next().trim()));
        }
        return tmpList.stream().mapToInt(value -> value).toArray();
    }

    private static Scanner getScanner() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("data.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sc;
    }

}
