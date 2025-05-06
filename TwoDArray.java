import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        // int sum = 0;
        // int[][] sumArr = new int[4][4];
        // for(int i=0;i<4;i++){
        //     for(int j=0;j<4;j++){
        //         sum = arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2)+
        //         arr.get(i+1).get(j+1)+
        //         arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2);
        //         sumArr[i][j] = sum;
        //     }
        // }

        // int maxSum = sumArr[0][0];
        // for(int i=0;i<4;i++){
        //     for(int j=0;j<4;j++){
        //         if(sumArr[i][j]>maxSum){
        //             maxSum = sumArr[i][j];
        //         }
        //     }
        // }
        // return maxSum;


        int sum = arr.get(0).get(0)+arr.get(0).get(1)+arr.get(0).get(2)+arr.get(1).get(1)+arr.get(2).get(0)+arr.get(2).get(1)+arr.get(2).get(2);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int tempSum = arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2)+
                        arr.get(i+1).get(j+1)+
                        arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2);
                if(sum<tempSum){
                    sum = tempSum;
                }
            }
        }
        return sum;



    }

}

public class TwoDArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
