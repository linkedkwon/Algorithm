package baekjoon.regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9342 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String regex = "^[A-F]?A+F+C+[A-F]?$";

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++)
            sb.append(br.readLine().matches(regex) ? "Infected!" : "Good").append('\n');

        System.out.println(sb);
        br.close();
    }
}