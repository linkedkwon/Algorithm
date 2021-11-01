package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[Integer.parseInt(br.readLine()) + 1][10];
        Arrays.fill(dp[1], 1);

        int sum = 0;
        for(int i = 1; i < dp.length; i++){
            if( i == 1){
                sum += 10;
                continue;
            }
            for(int j = 1; j < 10; j++){
                for(int k = j; k < 10; k++)
                    dp[i][j] += dp[i - 1][k] % 10007;
                sum += dp[i][j];
            }
        }
        System.out.println(sum % 10007);
        br.close();
    }
}