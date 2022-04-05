package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2775 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine()), k = Integer.parseInt(br.readLine());
            int[][] arr = new int[n + 1][k + 1];

            for(int i = 1; i <= k; i++)
                arr[0][i] = i;

            for(int i = 1; i <= n; i++){
                int sum = arr[i][1] = 1;
                for(int j = 2; j <= k; j++){
                    sum += arr[i - 1][j];
                    arr[i][j] = sum;
                }
            }
            sb.append(arr[n][k]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}