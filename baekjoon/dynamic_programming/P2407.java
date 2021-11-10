package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        BigInteger[][] dp = new BigInteger[N + 1][N + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = BigInteger.valueOf(1);
            dp[i][i] = BigInteger.valueOf(1);
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++)
                dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
        }

        System.out.println(dp[N][M]);
        br.close();
    }
}