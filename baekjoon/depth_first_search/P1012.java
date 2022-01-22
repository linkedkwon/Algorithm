package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012 {

    private static int[][] field;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static int M, N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            field = new int[M][N];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            int cnt = 0;
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(field[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int i, int j){
        field[i][j] = 0;

        for(int k = 0; k < 4; k++){
            int dx = i + x[k], dy = j + y[k];

            if(dx < 0 || dy < 0 || dx > M - 1 || dy > N - 1)
                continue;
            if(field[dx][dy] == 1)
                dfs(dx, dy);
        }

        return;
    }

}