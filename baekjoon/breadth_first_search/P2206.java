package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {

    public static class Point{
        int x;
        int y;
        int cnt;
        int breakCnt;

        public Point(int x, int y, int cnt, int breakCnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakCnt = breakCnt;
        }
    }

    private static int N, M;
    private static char[][] map;
    private static Queue<Point> queue;
    private static int[][] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        init();
        System.out.println(bfs());
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        br.close();
    }

    public static void init(){
        queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, 0));
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++)
                visited[i][j] = (int)10e9;
        }
        visited[0][0] = 1;
    }

    public static int bfs(){
        int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};

        int min = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.x == N - 1 && p.y == M - 1) {
                min = p.cnt;
                break;
            }

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy] <= p.breakCnt)
                    continue;

                if(map[dx][dy] == '0') {
                    visited[dx][dy] = p.breakCnt;
                    queue.add(new Point(dx, dy, p.cnt + 1, p.breakCnt));
                }
                else{
                    if(p.breakCnt == 0){
                        visited[dx][dy] = p.breakCnt + 1;
                        queue.add(new Point(dx, dy, p.cnt + 1, p.breakCnt + 1));
                    }
                }
            }
        }

        return min == 0 ? -1 : min;
    }

}