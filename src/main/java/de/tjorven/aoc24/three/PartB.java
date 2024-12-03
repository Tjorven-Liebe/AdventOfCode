package de.tjorven.aoc24.three;

public class PartB {

    public static void main(String[] args) {
        String[] input = SolverUtil.getInput("mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)");
        int solved = 0;
        boolean dont = false;
        for (String s : input) {
            String[] replace = s.replace("mul(", "").replace(")", "").split(",");
            if (s.equalsIgnoreCase("do()")) {
                dont = false;
                continue;
            } else if (s.equalsIgnoreCase("don't()")) {
                dont = true;
                continue;
            }
            if (dont) {
                continue;
            }

            try {
                solved += Integer.parseInt(replace[0]) * Integer.parseInt(replace[1]);
                System.out.println(s + "=" + solved);
            } catch (NumberFormatException ignored) {
            }
        }
        System.out.println(solved);
    }

}
