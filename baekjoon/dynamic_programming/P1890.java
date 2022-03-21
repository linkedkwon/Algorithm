package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1890 {

    static int N;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N]; dp = new long[N][N];
        dp[N - 1][N - 1] = 1;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static long dfs(int i, int j){
        long cnt = 0;
        if(arr[i][j] == 0) return 0;

        for(int d = 0; d < 2; d++){
            int dx = i, dy = j;
            if(d == 0) dx += arr[i][j];
            else dy += arr[i][j];

            if(dx >= N || dy >= N)
                continue;
            if(dp[dx][dy] > 0){
                cnt += dp[dx][dy];
                continue;
            }
            cnt += dfs(dx, dy);
        }
        dp[i][j] += cnt;
        return dp[i][j];
    }

}