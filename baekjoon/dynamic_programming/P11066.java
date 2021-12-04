package baekjoon.dynamic_programming.matrix_chain_multiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Knuth Optimization 바꾸기
public class P11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            for(int i = 1; i <= K; i++)
                sum[i] += sum[i - 1] + Integer.parseInt(st.nextToken());

            for(int len = 1; len < K ; len++){
                for(int i = 1; i <= K - len; i++){
                    int j = i + len;
                    dp[i][j] = Integer.MAX_VALUE;

                    for(int k = i; k < j; k++)
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    dp[i][j] += sum[j] - sum[i - 1];
                }
            }
            sb.append(dp[1][K] + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}