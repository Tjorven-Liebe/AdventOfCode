package de.tjorven.aoc24.one;

import java.io.IOException;

public class PartB {

    public static void main(String[] args) throws IOException {
        String[] split = SolverUtil.getInput();
        Pair<int[], int[]> arr = SolverUtil.getArr(split);
        int[] first = arr.getKey();
        int[] second = arr.getValue();

        int sum = 0;
        for (int index : first) {
            int count = count(index, second);
            sum += index * count;
        }

        System.out.println(sum);
    }

    private static int count(int index, int[] list) {
        int count = 0;
        for (int i : list) {
            if (i == index) {
                count++;
            }
        }
        return count;
    }

}
