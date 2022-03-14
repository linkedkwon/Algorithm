package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4889 {

    static int order = 1;
    static String str = "";
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!(str = br.readLine()).contains("-")){
            stack = new Stack<>();
            matchString();
            getParsingCnt();
        }
        System.out.println(sb);
        br.close();
    }

    static void matchString(){
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            boolean hasPop = false;
            while(!stack.isEmpty()){
                if(stack.peek() == '{' && c == '}'){
                    hasPop = true;
                    stack.pop();
                    break;
                }
                else
                    break;
            }
            if(!hasPop)
                stack.push(c);
        }
    }

    static void getParsingCnt(){
        int cnt = 0;
        for(int i = 0; i < stack.size(); i += 2)
            cnt += stack.get(i) == '}' && stack.get(i + 1) == '{' ? 2 : 1;
        sb.append(order++).append(". ").append(cnt).append('\n');
    }

}