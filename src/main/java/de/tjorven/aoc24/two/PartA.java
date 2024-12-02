package de.tjorven.aoc24.two;

public class PartA {

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

    private static boolean isSafe(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }

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

}
