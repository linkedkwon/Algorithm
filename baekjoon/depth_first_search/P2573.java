package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573 {

    private static class Point{
        int x, y, h;

        public Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    private static int N, M, answer = 0;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int[][] iceberg;

    public static void main(String[] args) throws IOException{
        readIn();
        int year = 0;
        while(true){
            int cnt = 0;
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(iceberg[i][j] != 0 && !visited[i][j]){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            if(cnt >= 2) {
                answer = year;
                break;
            }
            if(!meltIceberg())
                break;
            year++;
        }

        System.out.println(answer);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                iceberg[i][j] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    public static boolean meltIceberg(){
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int surrounded = 0;
                if(iceberg[i][j] != 0){
                    for(int d = 0; d < 4; d++){
                        int dx = i + x[d], dy = j + y[d];
                        if(dx < 0 || dy < 0 || dx >= N || dy >= M || iceberg[dx][dy] != 0)
                            continue;
                        surrounded++;
                    }
                    int h = iceberg[i][j] - surrounded;
                    queue.offer(new Point(i, j, h < 0 ? 0 : h));
                }
            }
        }

        boolean hasIceberg = false;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            iceberg[p.x][p.y] = p.h;
            if(p.h > 0)
                hasIceberg = true;
        }

        return hasIceberg;
    }

    public static void dfs(int i, int j){
        for(int d = 0; d < 4; d++){
            int dx = i + x[d], dy = j + y[d];
            if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy] || iceberg[dx][dy] == 0)
                continue;

            visited[dx][dy] = true;
            dfs(dx, dy);
        }
    }
}