package baekjoon.regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class P9996 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] subFix = pattern.split("\\*");
        String regex = "^" + subFix[0] + "[a-z]*" + subFix[1] +"$";

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() < pattern.length() - 1)
                sb.append("NE").append('\n');
            else
                sb.append(Pattern.matches(regex, str) ? "DA" : "NE").append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}