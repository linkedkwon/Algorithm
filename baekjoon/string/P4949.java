package baekjoon.string;

import java.io.*;
import java.util.Stack;

public class P4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while(!(str = br.readLine()).equals(".")) {
            int flag = 1;
            Stack<Character> stack = new Stack<>();
            stack.push('0');
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                else if(c == ')'){
                    if(stack.peek() != '('){
                        flag = 0;
                        break;
                    }
                    stack.pop();
                }
                else if(c == ']'){
                    if(stack.peek() != '['){
                        flag = 0;
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.pop() != '0')
                flag = 0;
            sb.append(flag == 1 ? "yes":"no");
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}