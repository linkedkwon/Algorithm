package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":stack.add(Integer.parseInt(st.nextToken())); break;
                case "pop":sb.append(stack.isEmpty() ? "-1\n" : stack.pop() + "\n"); break;
                case "size":sb.append(stack.size()+"\n"); break;
                case "empty":sb.append(stack.isEmpty() ? "1\n" : "0\n"); break;
                case "top":sb.append(stack.isEmpty() ? "-1\n" : stack.peek() + "\n"); break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}