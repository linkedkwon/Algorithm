package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[Integer.parseInt(br.readLine())];

        for(int i = 0; i < n.length; i++)
            n[i] = Integer.parseInt(br.readLine());

        int max = Arrays.stream(n).max().getAsInt();
        int[][] dp = new int[max + 1][2];
        dp[0] = new int[]{1, 0}; dp[1] = new int[]{0, 1};

        for(int i = 0; i < dp.length; i++){
            if(i == 0 || i == 1)
                continue;
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for(int i = 0; i < n.length; i++)
            System.out.println(dp[n[i]][0]+" "+dp[n[i]][1]);
    }
}