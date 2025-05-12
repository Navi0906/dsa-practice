import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            sum1 += h1.get(i);
            stack1.push(sum1);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            sum2 += h2.get(i);
            stack2.push(sum2);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            sum3 += h3.get(i);
            stack3.push(sum3);
        }

        while (true) {
            if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
                return 0;
            }

            int height1 = stack1.peek();
            int height2 = stack2.peek();
            int height3 = stack3.peek();

            if (height1 == height2 && height2 == height3) {
                return height1;
            }


            if (height1 >= height2 && height1 >= height3) {
                stack1.pop();
            } else if (height2 >= height1 && height2 >= height3) {
                stack2.pop();
            } else {
                stack3.pop();
            }
        }
    }

}

public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
