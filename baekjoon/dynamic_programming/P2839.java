package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 0; dp[1] = 5001; dp[2] = 5001;

        for(int i = 3; i < dp.length; i++){
            if(i - 5 < 0){
                dp[i] = dp[i - 3] + 1;
                continue;
            }
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }

        System.out.println(dp[n] > n ? -1 : dp[n]);
        br.close();
    }
}
