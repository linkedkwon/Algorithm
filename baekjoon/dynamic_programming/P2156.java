package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[Integer.parseInt(br.readLine()) + 1];
        for(int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[arr.length];

        int max = 0;
        for(int i = 1; i < arr.length; i++){
            if( i < 3){
                dp[i] = dp[i - 1] + arr[i];
                max = dp[i];
                continue;
            }
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i] , dp[i - 2] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        br.close();
    }
}