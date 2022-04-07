package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2747 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 2];
        dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++)
            dp[i] = dp[i - 2] + dp[i - 1];

        System.out.println(dp[n]);
        br.close();
    }

}