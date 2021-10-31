package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine()) + 1];

        for(int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[arr.length];

        for(int i = 1; i < dp.length; i++) {
            if(i < 3){
                dp[i] = dp[i - 1] + arr[i];
                continue;
            }
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
        }

        System.out.println(dp[dp.length - 1]);
        br.close();
    }
}