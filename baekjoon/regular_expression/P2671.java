package baekjoon.regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2671 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine().matches("(100+1+|01)+") ? "SUBMARINE" : "NOISE");
        br.close();
    }

}
