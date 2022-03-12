package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9656 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        readIn();
        dp();
        System.out.println(dp[N] % 2 == 0 ? "SK" : "CY");
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 4];
        br.close();
    }

    static void dp(){
        dp[1] = dp[3] = 1; dp[2] = dp[4] = 2;
        for(int i = 5; i <= N; i++)
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
    }

}