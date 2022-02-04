package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1743 {

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N, M, K, MAX = 0;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static int[][] map;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 1){
                    queue.offer(new Point(i, j));
                    map[i][j] = 0;
                    bfs();
                }
            }
        }
        System.out.println(MAX);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        queue = new LinkedList<>();
        br.close();
    }

    public static void bfs(){
        int cnt = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            cnt++;

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 1 || dy < 1 || dx > N || dy > M || map[dx][dy] == 0)
                    continue;
                queue.offer(new Point(dx, dy));
                map[dx][dy] = 0;
            }
        }
        MAX = Math.max(MAX, cnt);
    }

}
