import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleSolver {

    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = PuzzleSolver.class.getClassLoader().getResourceAsStream("input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        StringBuilder builder = new StringBuilder();
        bufferedReader.lines().forEach(s -> builder.append(s).append("   "));

        String splitId = "   ";
        String[] split = builder.toString().split(splitId);

        List<Integer> arrA = new ArrayList<>();
        List<Integer> arrB = new ArrayList<>();
        int i = 0;
        while (i < split.length) {
            if (i++ % 2 == 0) {
                arrA.add(Integer.parseInt(split[i - 1]));
            } else {
                arrB.add(Integer.parseInt(split[i - 1]));
            }
        }

        Collections.sort(arrA);
        Collections.sort(arrB);

        StringBuilder equation = new StringBuilder("Sum of absolute differences is: ");
        int sum = 0;
        for (int j = 0; j < arrA.size(); j++) {
            sum += Math.abs(arrA.get(j) - arrB.get(j));
            equation.append(Math.abs(arrA.get(j) - arrB.get(j)));
            if (j != arrA.size() - 1) {
                equation.append(" + ");
            }
        }
        System.out.println(equation + "=" + sum);
    }

}
