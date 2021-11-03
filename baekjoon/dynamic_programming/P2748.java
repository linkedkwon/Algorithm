package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++) {
            if(i < 3){
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
        br.close();
    }
}