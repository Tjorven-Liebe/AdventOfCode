package de.tjorven.aoc24.four;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class SolverUtil {

    static char[][] getInput() {
        InputStream resourceAsStream = SolverUtil.class.getClassLoader().getResourceAsStream("four/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        List<String> lines = bufferedReader.lines().toList();
        char[][] chars = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            chars[i] = lines.get(i).toCharArray();
        }
        return chars;
    }
}
