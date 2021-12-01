package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//LIS table version
public class P2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[501][501];
        int len = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken());
            len = Math.max(len, Math.max(dx, dy));
            dp[dx][dy]++;
        }

        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= len; j++){
                dp[i][j] = dp[i][j] == 1 ? dp[i - 1][j - 1] + 1 :
                        Math.max(dp[i -1][j], dp[i][j - 1]);
            }
        }

        System.out.println(N - dp[len][len]);
        br.close();
    }
}