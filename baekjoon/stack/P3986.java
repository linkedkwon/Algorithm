package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P3986 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int n = 0; n < N; n++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(stack.isEmpty() || stack.peek() != c)
                    stack.push(c);
                else
                    stack.pop();
            }
            if(stack.isEmpty())
                cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}