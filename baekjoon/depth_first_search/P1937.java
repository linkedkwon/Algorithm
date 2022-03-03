package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1937 {

    static int N;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                dfs(i, j);
        }

        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N]; dp = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        br.close();
    }

    static void writeOut(){
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                max = Math.max(max, dp[i][j]);
        }
        System.out.println(max);
    }

    static int dfs(int r, int c){
        if(dp[r][c] != -1)
            return dp[r][c];
        dp[r][c] = 1;
        for(int d = 0; d < 4; d++){
            int dx = r + x[d], dy = c + y[d];
            if(dx < 0 || dy < 0 || dx >= N || dy >= N || arr[dx][dy] <= arr[r][c])
                continue;
            dp[r][c] = Math.max(dp[r][c], dfs(dx, dy) + 1);
        }
        return dp[r][c];
    }

}