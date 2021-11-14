package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] T = new int[Integer.parseInt(br.readLine())];

        for(int t = 0; t < T.length; t++) {

            int[] arr = new int[Integer.parseInt(br.readLine())];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];
            dp[0] = 1;
            for (int i = 0; i < arr.length; i++) {
                for (int j = arr[i]; j < dp.length; j++)
                    dp[j] += dp[j - arr[i]];
            }
            T[t] = dp[M];
        }

        for(int i = 0; i < T.length; i++)
            System.out.println(T[i]);
        br.close();
    }
}