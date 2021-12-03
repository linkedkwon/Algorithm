package baekjoon.dynamic_programming.matrix_chain_multiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] m = new int[N + 1];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m[i] = Integer.parseInt(st.nextToken());
            m[i + 1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N + 1];
        for(int len = 1; len < N; len++){
            for(int i = 1; i <= N - len; i++){
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = i; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + m[i - 1] * m[k] * m[j]);
            }
        }

        System.out.println(dp[1][N]);
        br.close();
    }
}