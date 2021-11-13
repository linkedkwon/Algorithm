package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] w = new int[N + 1], v = new int[N + 1];
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];

        for(int i = 1; i < N + 1; i++){
            for(int j = K; j >= w[i]; j--)
                dp[j] = Math.max(dp[j - w[i]] + v[i], dp[j]);
        }

        System.out.println(dp[K]);
        br.close();
    }
}