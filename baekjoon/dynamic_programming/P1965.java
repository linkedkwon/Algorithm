package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1], dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = 1;
        int max = 0;
        for(int i = 2; i < N + 1; i++){
            dp[i] = 1;
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
        br.close();
    }
}