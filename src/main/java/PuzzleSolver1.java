import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleSolver1 {

    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = PuzzleSolver1.class.getClassLoader().getResourceAsStream("input1.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        StringBuilder builder = new StringBuilder();
        bufferedReader.lines().forEach(s -> builder.append(s).append("   "));

        String splitId = "   ";
        String[] split = builder.toString().split(splitId);

        List<Integer> indexes = new ArrayList<>();
        List<Integer> arrB = new ArrayList<>();
        int i = 0;
        while (i < split.length) {
            if (i++ % 2 == 0) {
                indexes.add(Integer.parseInt(split[i - 1]));
            } else {
                arrB.add(Integer.parseInt(split[i - 1]));
            }
        }

        int sum = 0;
        StringBuilder equation = new StringBuilder("Sum of absolute differences is: ");
        for (int index : indexes) {
            int count = count(index, arrB);
            sum += index * count;
            equation.append("+ ").append(index).append(" * ").append(count);
        }
        System.out.println(equation + " = " + sum);
    }

    private static int count(int a, List<Integer> arrB) {
        int count = 0;
        for (int i : arrB) {
            if (i == a) {
                count++;
            }
        }
        return count;
    }

}
