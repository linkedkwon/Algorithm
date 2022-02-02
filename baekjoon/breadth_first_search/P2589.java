package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2589 {

    private static class Point{
        int x, y, t;

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    private static int N, M, max = 0;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static char[][] map;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited = new boolean[N][M];
                if(!visited[i][j] && map[i][j] == 'L'){
                    queue.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                    bfs();
                }
            }
        }

        System.out.println(max);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        queue = new LinkedList<>();
        br.close();
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            max = Math.max(max, p.t);

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= M)
                    continue;
                if(visited[dx][dy] || map[dx][dy] == 'W')
                    continue;

                queue.offer(new Point(dx, dy, p.t + 1));
                visited[dx][dy] = true;
            }
        }
    }

}