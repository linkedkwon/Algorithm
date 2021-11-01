package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine()) + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[arr.length];
        dp[0] = 0; dp[1] = 1;

        for(int i = 2; i < arr.length; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[i] > arr[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }

        int max = dp[0];
        for(int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
        br.close();
    }
}
