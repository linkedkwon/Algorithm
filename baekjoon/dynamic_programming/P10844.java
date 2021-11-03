package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[Integer.parseInt(br.readLine())][12];

        for(int i = 2; i < 11; i++)
            dp[0][i] = 1;

        long cnt = 9;
        int mod = 1000000000;

        for(int i = 1; i < dp.length; i++){
            cnt = 0;
            for(int j = 1; j < 11; j++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= mod;
                cnt += dp[i][j];
            }
        }

        System.out.println(cnt % mod);
        br.close();
    }
}