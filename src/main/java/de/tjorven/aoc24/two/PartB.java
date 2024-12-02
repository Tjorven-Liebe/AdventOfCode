package de.tjorven.aoc24.two;

public class PartB {

    private static boolean isSafe(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }

        if (isStrictlySafe(arr)) {
            return true;
        }

        for (int i = 0; i < arr.length; i++) {
            int[] modifiedArr = new int[arr.length - 1];
            for (int j = 0, k = 0; j < arr.length; j++) {
                if (j != i) {
                    modifiedArr[k++] = arr[j];
                }
            }
            if (isStrictlySafe(modifiedArr)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isStrictlySafe(int[] arr) {
        int direction = 0;

        for (int i = 1; i < arr.length; i++) {
            int difference = arr[i] - arr[i - 1];

            if (Math.abs(difference) < 1 || Math.abs(difference) > 3) {
                return false;
            }

            if (direction == 0) {
                direction = (difference > 0) ? 1 : -1;
            } else {
                if ((direction == 1 && difference < 0) || (direction == -1 && difference > 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] input = SolverUtil.getInput();
        int areSafe = 0;
        for (int[] ints : input) {
            if (isSafe(ints)) {
                areSafe++;
            }
        }
        System.out.println("areSafe: " + areSafe);
    }
}
