package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];

        for (int i = 0; i < dp.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++)
                dp[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] += dp[i - 1][0];
            dp[i][i] += dp[i - 1][i - 1];

            for (int j = 1; j < i; j++)
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
        }

        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[n - 1][i]);

        System.out.println(max);
        br.close();
    }
}