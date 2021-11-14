package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P10826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[n + 2];
        dp[0] = BigInteger.valueOf(0); dp[1] = BigInteger.valueOf(1);

        for(int i = 2; i < dp.length; i++)
            dp[i] = dp[i - 2].add(dp[i - 1]);

        System.out.println(dp[n]);
        br.close();
    }
}