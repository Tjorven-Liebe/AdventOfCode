package de.tjorven.aoc24.four;

public class PartB {

    public static void main(String[] args) {
        char[][] input = SolverUtil.getInput();
        int count = countXMAS(input);
        System.out.println("Total X-MAS occurrences: " + count);
    }

    public static int countXMAS(char[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int totalCount = 0;

        for (int row = 1; row < rowCount - 1; row++) {
            for (int col = 1; col < colCount - 1; col++) {
                if (grid[row][col] == 'A') {
                    if (isXMAS(grid, row, col)) {
                        totalCount++;
                    }
                }
            }
        }

        return totalCount;
    }

    private static boolean isXMAS(char[][] grid, int centerRow, int centerCol) {
        String[] validPatterns = {"MAS", "SAM"};

        int[][] diagonalPositions = {
                {centerRow - 1, centerCol - 1},
                {centerRow + 1, centerCol + 1},
                {centerRow - 1, centerCol + 1},
                {centerRow + 1, centerCol - 1}
        };

        String firstDiagonal = String.valueOf(grid[diagonalPositions[0][0]][diagonalPositions[0][1]]) +
                               grid[centerRow][centerCol] +
                               grid[diagonalPositions[1][0]][diagonalPositions[1][1]];

        String secondDiagonal = String.valueOf(grid[diagonalPositions[2][0]][diagonalPositions[2][1]]) +
                                grid[centerRow][centerCol] +
                                grid[diagonalPositions[3][0]][diagonalPositions[3][1]];

        boolean firstDiagonalValid = isValidPattern(firstDiagonal, validPatterns);
        boolean secondDiagonalValid = isValidPattern(secondDiagonal, validPatterns);

        return firstDiagonalValid && secondDiagonalValid;
    }

    private static boolean isValidPattern(String diagonal, String[] validPatterns) {
        for (String pattern : validPatterns) {
            if (diagonal.equals(pattern)) {
                return true;
            }
        }
        return false;
    }

}
