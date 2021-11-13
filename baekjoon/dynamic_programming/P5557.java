package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5557 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        long[][] dp = new long[21][N + 1];
        dp[arr[1]][2] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[j][i] > 0){
                    int dx = j + arr[i], dy = j - arr[i];
                    if(dx <= 20) dp[dx][i + 1] += dp[j][i];
                    if(dy >= 0) dp[dy][i + 1] += dp[j][i];
                }
            }
        }

        System.out.println(dp[arr[N]][N]);
        br.close();
    }
}