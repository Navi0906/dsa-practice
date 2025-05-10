import java.util.*;

public class EqualStacks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            h1[i] = scanner.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            h2[i] = scanner.nextInt();
        }

        for (int i = 0; i < n3; i++) {
            h3[i] = scanner.nextInt();
        }

        int sum1 = 0, sum2 = 0, sum3 = 0;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        for (int i = n1 - 1; i >= 0; i--) {
            sum1 += h1[i];
            s1.push(sum1);
        }

        for (int i = n2 - 1; i >= 0; i--) {
            sum2 += h2[i];
            s2.push(sum2);
        }

        for (int i = n3 - 1; i >= 0; i--) {
            sum3 += h3[i];
            s3.push(sum3);
        }

        while (true) {
            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
                System.out.println(0);
                return;
            }

            int top1 = s1.peek();
            int top2 = s2.peek();
            int top3 = s3.peek();

            if (top1 == top2 && top2 == top3) {
                System.out.println(top1);
                return;
            }

            if (top1 >= top2 && top1 >= top3) {
                s1.pop();
            } else if (top2 >= top1 && top2 >= top3) {
                s2.pop();
            } else {
                s3.pop();
            }
        }
    }
}