package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(), sub = br.readLine();

        Stack<Character> stack = new Stack<>();
        int top = sub.length() - 1;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            stack.push(c);

            if(sub.indexOf(c) == top && stack.size() > top) {
                boolean flag = true;
                for (int j = 0; j < sub.length(); j++) {
                    if(stack.get(stack.size() - 1 - j) != sub.charAt(top - j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j = 0; j < sub.length(); j++)
                        stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i++)
            sb.append(stack.get(i));

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
        br.close();
    }
}