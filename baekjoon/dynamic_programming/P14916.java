package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14916 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 5];

        dp[1] = dp[3] = n; dp[2] = dp[5] = 1; dp[4] = 2;
        for(int i = 6; i <= n; i++)
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;

        System.out.println(dp[n] >= n ? "-1" : dp[n]);
        br.close();
    }

}