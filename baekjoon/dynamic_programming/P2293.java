package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        dp[0] = 1;

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            for(int j = arr[i]; j < dp.length; j++)
                dp[j] += dp[j - arr[i]];
        }
        System.out.println(dp[K]);
        br.close();
    }
}