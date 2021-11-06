package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[Integer.parseInt(br.readLine())];

        for(int cnt = 0; cnt < answer.length; cnt++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N + 2];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N + 1; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][N + 2];
            dp[0][1] = arr[0][1]; dp[1][1] = arr[1][1];
            dp[0][2] = dp[0][1] + arr[0][2]; dp[1][2] = dp[1][1] + arr[1][2];

            for(int i = 2; i < dp[0].length; i++){
                dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i];
            }
            answer[cnt] = Math.max(dp[0][N], dp[1][N]);
        }

        for(int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);
        br.close();
    }
}