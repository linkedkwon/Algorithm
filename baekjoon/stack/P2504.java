package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P2504 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int answer = 0, mul = 1;
        boolean flag = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                mul *= 2;
                stack.push(c);
            }
            else if(c == '['){
                mul *= 3;
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    flag = false;
                    break;
                }
                if(str.charAt(i - 1) == '(')
                    answer += mul;
                stack.pop();
                mul /= 2;
            }
            else{
                if(stack.isEmpty() || stack.peek() != '['){
                    flag = false;
                    break;
                }
                if(str.charAt(i - 1) == '[')
                    answer += mul;
                stack.pop();
                mul /= 3;
            }
        }

        if(!stack.isEmpty())
            System.out.println("0");
        else
            System.out.println(flag ? answer : 0);
        br.close();
    }
}