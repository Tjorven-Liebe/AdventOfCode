package de.tjorven.aoc24.one;

import java.io.IOException;
import java.util.Arrays;

public class PartA {

    public static void main(String[] args) throws IOException {
        String[] input = SolverUtil.getInput();
        Pair<int[], int[]> arr = SolverUtil.getArr(input);

        int[] first = arr.getKey();
        int[] second = arr.getValue();

        Arrays.sort(first);
        Arrays.sort(second);

        int sum = 0;
        for (int j = 0; j < first.length-1; j++) {
            sum += Math.abs(first[j] - second[j]);
        }
        System.out.println(sum);
    }

}
