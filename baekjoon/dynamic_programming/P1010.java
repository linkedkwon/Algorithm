package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[30][30];
        for(int i = 1; i < dp.length; i++)
            dp[1][i] = i;

        for(int i = 2; i < dp.length; i++){
            dp[i][i] = 1;
            for(int j = i + 1; j < dp[i].length; j++)
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        }

        int[] arr = new int[Integer.parseInt(br.readLine())];
        for(int i = 0; i < arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = dp[Integer.parseInt(st.nextToken())]
                    [Integer.parseInt(st.nextToken())];
        }

        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        br.close();
    }
}