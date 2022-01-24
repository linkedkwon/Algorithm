package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P2468 {

    private static int N, H;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static int[][] field;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int in = Integer.parseInt(st.nextToken());
                field[i][j] = in;
                set.add(in);
            }
        }

        int max = 1;
        for(int h : set){
            visited = new boolean[N][N];
            int cnt = 0; H = h;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(field[i][j] > h && !visited[i][j]){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
        br.close();
    }

    public static void dfs(int i, int j){
        visited[i][j] = true;

        for(int n = 0; n < 4; n++){
            int dx = i + x[n], dy = j + y[n];

            if(dx < 0 || dy < 0 || dx >= N || dy >= N)
                continue;
            if(field[dx][dy] > H && !visited[dx][dy])
                dfs(dx, dy);
        }

    }

}