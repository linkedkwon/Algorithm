package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine())];

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long[] dp = new long[max + 5];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i = 4; i < dp.length; i++)
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;

        for(int i = 0; i < arr.length; i++)
            System.out.println(dp[arr[i]]);
        br.close();
    }
}