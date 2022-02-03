package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3109 {

    private static int R, C, cnt = 0;
    private static boolean flag = false;
    private static int[] x = {-1, 0, 1}, y = {1, 1, 1};
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < R; i++){
            flag = false;
            dfs(i, 0);
        }
        System.out.println(cnt);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();

        br.close();
    }

    public static void dfs(int i, int j){
        visited[i][j] = true;
        if(j == C - 1){
            flag = true;
            cnt++;
            return;
        }

        for(int d = 0; d < 3; d++){
            int dx = i + x[d], dy = j + y[d];
            if(dx < 0 || dy >= C || dx >= R)
                continue;
            if(map[dx][dy] == 'x' || visited[dx][dy] || flag)
                continue;
            dfs(dx, dy);
        }
    }

}