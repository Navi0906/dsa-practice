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

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Map<Long,Long> rightMap = new HashMap<>();
        Map<Long,Long> leftMap = new HashMap<>();
        long ans = 0L;

        for(long var:arr){
            rightMap.put(var,rightMap.getOrDefault(var, 0L)+1);
        }

        for(long var:arr){
            rightMap.put(var,rightMap.getOrDefault(var, 0L)-1);

            long a = var/r;
            long b = var;
            long c = var*r;

            if((var%r)==0 && leftMap.containsKey(a) && rightMap.containsKey(c)){
                ans+=(leftMap.get(a)*rightMap.get(c));
            }

            leftMap.put(var, leftMap.getOrDefault(var, 0L)+1);
        }

        return ans;



        // long count = 0;

        // for(int i=0;i<arr.size()-2;i++){
        //     for(int j=i+1;j<arr.size()-1;j++){
        //         for(int k=j+1;k<arr.size();k++){
        //             if(arr.get(k)/arr.get(j) == r && arr.get(j) /arr.get(i) == r){
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
