package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[Integer.parseInt(br.readLine()) + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int dp[] = new int[arr.length];
        dp[0] = -1001; dp[1] = arr[1];

        for(int i = 2; i < arr.length; i++)
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);
        br.close();
    }
}
