package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];

        for(int i = 1; i < dp.length; i++)
            dp[i] = 10001;

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j = n; j < dp.length; j++)
                dp[j] = Math.min(dp[j], dp[j - n] + 1);
        }

        int answer = dp[K] <= K ? dp[K] : -1;
        System.out.println(answer);
        br.close();
    }
}