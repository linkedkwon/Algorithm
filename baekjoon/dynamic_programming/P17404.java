package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        for(int i = 0; i < arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][3];
        int min = -1;
        for(int i = 0; i < 3; i++){
            dp[0][i] = arr[0][i];
            for(int idx = 0; idx < 3; idx++) {
                if(i != idx)
                    dp[0][idx] = 1001;
            }

            for(int j = 1; j < dp.length; j++){
                for(int k = 0; k < 3; k++){
                    if(k == 0)
                        dp[j][k] = Math.min(dp[j - 1][k + 1], dp[j - 1][k + 2]) + arr[j][k];
                    if(k == 1)
                        dp[j][k] = Math.min(dp[j - 1][k - 1], dp[j - 1][k + 1]) + arr[j][k];
                    if(k == 2)
                        dp[j][k] = Math.min(dp[j - 1][k - 2], dp[j - 1][k - 1]) + arr[j][k];
                }
            }

            for(int idx = 0; idx < 3; idx++){
                if(idx == i)
                    continue;
                if(min == -1)
                    min = dp[N - 1][idx];
                min = Math.min(min, dp[N - 1][idx]);
            }
        }
        System.out.println(min);
        br.close();
    }
}