package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        for(int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int dx = 0, n = 1;
        while(n <= N || !stack.isEmpty()){
            if(n <= seq[dx]){
                stack.add(n++);
                sb.append("+\n");
            }
            else{
                if(stack.pop() != seq[dx++])
                    break;
                sb.append("-\n");
            }
        }

        System.out.println(stack.isEmpty() ? sb : "NO");
        br.close();
    }
}