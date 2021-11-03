package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[Integer.parseInt(br.readLine())][3];

        for(int i = 0; i < arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[arr.length][3];
        dp[0][0] = arr[0][0]; dp[0][1] = arr[0][1]; dp[0][2] = arr[0][2];

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < 3; j++){
                if( j == 0)
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]);
                if( j == 1)
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]);
                if( j == 2)
                    dp[i][j] = Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]);

                dp[i][j] += arr[i][j];
            }
        }

        int min = dp[dp.length - 1][0];
        for(int i = 0; i < 3; i++)
            min = Math.min(min, dp[dp.length - 1][i]);

        System.out.println(min);
        br.close();
    }
}