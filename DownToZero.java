import java.util.Scanner;

public class DownToZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            System.out.println(minMovesToZero(n));
        }
        scanner.close();
    }

    public static int minMovesToZero(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // Option 2: decrement by 1
            for (int a = 2; a <= Math.sqrt(i); a++) {
                if (i % a == 0) {
                    int b = i / a;
                    dp[i] = Math.min(dp[i], dp[Math.max(a, b)] + 1);
                }
            }
        }
        return dp[N];
    }
}
