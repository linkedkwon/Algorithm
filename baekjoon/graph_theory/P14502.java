package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int N, M, max = 0;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
        br.close();
    }

    public static void dfs(int depth){
        if(depth == 3) {
            bfs();
            return;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();

        int[][] copy = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                copy[i][j] = map[i][j];
                if(copy[i][j] == 2)
                    queue.offer(new Point(i, j));
            }
        }

        while(!queue.isEmpty()){
            Point obj = queue.poll();
            for(int i = 0; i < 4; i++){
                int dx = obj.x + x[i], dy = obj.y + y[i];
                if(dx < 1 || dy < 1 || dx > N || dy > M)
                    continue;
                if(copy[dx][dy] == 0){
                    queue.offer(new Point(dx, dy));
                    copy[dx][dy] = 2;
                }
            }
        }

        max = Math.max(max, countSafeZone(copy));
    }

    public static int countSafeZone(int[][] map){
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }

}