package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1520 {

    static int N, M;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException{
        readIn();
        System.out.println(dfs(0, 0));
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M]; dp = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        br.close();
    }

    static int dfs(int r, int c){
        if(r == N - 1 && c == M - 1)
            return 1;
        if(dp[r][c] != -1)
            return dp[r][c];

        dp[r][c] = 0;
        for(int d = 0; d < 4; d++){
            int dx = r + x[d], dy = c + y[d];
            if(dx < 0 || dy < 0 || dx >= N || dy >= M || arr[r][c] <= arr[dx][dy])
                continue;
            dp[r][c] += dfs(dx, dy);
        }

        return dp[r][c];
    }

}