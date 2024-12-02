package de.tjorven.aoc24.two;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SolverUtil {

    public static int[][] getInput() {
        InputStream resourceAsStream = de.tjorven.aoc24.one.SolverUtil.class.getClassLoader().getResourceAsStream("two/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        List<String> lines = bufferedReader.lines().toList();
        int[][] result = new int[lines.size()][];
        AtomicInteger row = new AtomicInteger();
        lines.forEach(line -> {
//            System.out.println(line);
            result[row.get()] = Arrays.stream(line.split(" ")).map(Integer::parseInt).mapToInt(i -> i).toArray();
            row.getAndIncrement();
        });
        return result;
    }

}
