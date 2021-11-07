package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            dp[i] = i + 1;
            for(int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
        }
        System.out.println(dp[N]);
        br.close();
    }
}