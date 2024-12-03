package de.tjorven.aoc24.three;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolverUtil {

    public static String[] getInput(String regex) {
        InputStream resourceAsStream = de.tjorven.aoc24.one.SolverUtil.class.getClassLoader().getResourceAsStream("three/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        List<String> lines = bufferedReader.lines().toList();
        StringBuilder builder = new StringBuilder();
        lines.forEach(builder::append);
        Matcher matcher = Pattern.compile(regex).matcher(builder);
        List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches.toArray(new String[0]);
    }

}
