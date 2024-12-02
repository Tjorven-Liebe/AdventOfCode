package de.tjorven.aoc24.one;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SolverUtil {

    private SolverUtil() {

    }

    public static String[] getInput() {
        InputStream resourceAsStream = SolverUtil.class.getClassLoader().getResourceAsStream("one/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        StringBuilder builder = new StringBuilder();
        bufferedReader.lines().forEach(s -> builder.append(s).append("   "));

        return builder.toString().split("   ");
    }

    public static Pair<int[], int[]> getArr(String[] input) {
        int[] arrA = new int[input.length];
        int[] arrB = new int[input.length];
        int i = 0;
        while (i < input.length-1) {
            if (i++ % 2 == 0) {
                arrA[i] = Integer.parseInt(input[i - 1]);
            } else {
                arrB[i] = Integer.parseInt(input[i - 1]);
            }
        }
        return new Pair<>(arrA, arrB);
    }

}
