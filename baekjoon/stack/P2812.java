package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2812 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            char c = str.charAt(i);

            while(!stack.isEmpty() && !(stack.size() == i - K)){
                if(stack.peek() < c)
                    stack.pop();
                else
                    break;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        int dx = 0;
        for(Character c : stack) {
            if(dx++ == N - K)
                break;
            sb.append(c);
        }
        System.out.println(sb);
        br.close();
    }
}