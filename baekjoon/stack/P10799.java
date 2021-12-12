package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stick = br.readLine();

        int depth = 0, cnt = 0, end = stick.length() - 1;
        char c1 = stick.charAt(end);
        for(int i = end - 1; i >= 0; i--){
            char c2 = stick.charAt(i);
            if(c1 == ')' && c2 == ')')
                depth++;
            else if(c1 == ')' && c2 =='(')
                cnt += depth;
            else if(c1 == '(' && c2 == '('){
                cnt += 1;
                depth--;
            }
            c1 = c2;
        }

        System.out.println(cnt);
        br.close();
    }
}