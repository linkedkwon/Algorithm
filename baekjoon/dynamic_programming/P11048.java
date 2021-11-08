package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];

        for(int i = 1; i < dp.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken()) +
                        Math.max(dp[i - 1][j -1], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        System.out.println(dp[N][M]);
        br.close();
    }
}