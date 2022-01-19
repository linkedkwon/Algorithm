package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9625 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[K + 2][2];

        dp[1][1] = dp[2][0] = dp[2][1] = 1;

        for(int i = 3; i < K + 1; i++){
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        System.out.println(dp[K][0] + " " + dp[K][1]);
        br.close();
    }

}