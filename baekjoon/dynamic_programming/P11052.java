package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for(int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        dp[1] = arr[1];

        for(int i = 2; i < arr.length; i++) {
            for(int j = 1; j < i + 1; j++)
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
        }
        System.out.println(dp[N]);
        br.close();
    }
}