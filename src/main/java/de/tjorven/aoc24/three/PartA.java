package de.tjorven.aoc24.three;

public class PartA {

    public static void main(String[] args) {
        String[] input = SolverUtil.getInput("mul\\(\\d+,\\d+\\)");
        int solved = 0;
        for (String s : input) {
            String[] replace = s.replace("mul(", "").replace(")", "").split(",");

            solved += Integer.parseInt(replace[0]) * Integer.parseInt(replace[1]);
        }
        System.out.println(solved);
    }

}
