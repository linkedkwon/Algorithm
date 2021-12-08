package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringBuilder sub = new StringBuilder();
        String s = br.readLine();

        boolean isBracket = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '<') {
                isBracket = true;
                if(sub.length() > 0)
                    appendSub(answer, sub);
                answer.append(c);
            }
            else if(c == '>') {
                isBracket = false;
                answer.append(c);
            }
            else if(c == ' ') {
                if(sub.length() > 0)
                    appendSub(answer, sub);
                answer.append(c);
            }
            else {
                if(isBracket) answer.append(c);
                else sub.append(c);
            }
        }

        if(sub.length() > 0)
            answer.append(sub.reverse());
        System.out.println(answer);
        br.close();
    }

    public static void appendSub(StringBuilder sb1, StringBuilder sb2){
        sb1.append(sb2.reverse());
        sb2.delete(0, sb2.length());
    }
}