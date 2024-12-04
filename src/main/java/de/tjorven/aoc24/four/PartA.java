package de.tjorven.aoc24.four;

public class PartA {

    public static void main(String[] args) {
        char[][] input = SolverUtil.getInput();
        String target = "XMAS";
        int count = countWordOccurrences(input, target);
        System.out.println(count);
    }

    public static int countWordOccurrences(char[][] grid, String word) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int totalOccurrences = 0;

        int[][] directions = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
                {1, 1},
                {-1, -1},
                {1, -1},
                {-1, 1}
        };

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                for (int[] direction : directions) {
                    int rowStep = direction[0];
                    int colStep = direction[1];
                    if (matchesWord(grid, row, col, word, rowStep, colStep)) {
                        totalOccurrences++;
                    }
                }
            }
        }

        return totalOccurrences;
    }

    private static boolean matchesWord(char[][] grid, int startRow, int startCol, String word, int rowStep, int colStep) {
        int wordLength = word.length();
        int rowCount = grid.length;
        int colCount = grid[0].length;

        for (int i = 0; i < wordLength; i++) {
            int currentRow = startRow + i * rowStep;
            int currentCol = startCol + i * colStep;

            if (currentRow < 0 || currentRow >= rowCount || currentCol < 0 || currentCol >= colCount) {
                return false;
            }

            if (grid[currentRow][currentCol] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
