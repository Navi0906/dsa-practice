import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q =sc.nextInt();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i=0;i<q;i++){
            int n=sc.nextInt();


            if(n==1){
                int query=sc.nextInt();
                stack1.push(query);
            }
            else if(n==2){
                if(stack2.isEmpty()){
                    while(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }}
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            else if(n==3){
                if(stack2.isEmpty()){
                    while(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                if(!stack2.isEmpty()){
                    int m = stack2.peek();
                    System.out.println(m);
                }
            }
        }

    }
}
