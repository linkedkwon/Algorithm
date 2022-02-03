package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {

    private static class Point{
        int x, y, t;
        boolean isJiHoon;

        public Point(int x, int y, int t, boolean isJiHoon) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.isJiHoon = isJiHoon;
        }
    }

    private static int R, C, T = 0;
    private static char[][] map;
    private static boolean[][] visited;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        System.out.println(T == 0 ? "IMPOSSIBLE" : T);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        queue = new LinkedList<>();

        int dx = 0, dy = 0;
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                char c = str.charAt(j);
                map[i][j] = c;
                if(c == 'J'){
                    dx = i; dy = j;
                }else if(c == 'F'){
                    queue.offer(new Point(i, j, 0, false));
                    visited[i][j] = true;
                }
            }
        }

        queue.offer(new Point(dx, dy, 0, true));
        visited[dx][dy] = true;
        br.close();
    }

    public static void bfs(){
        int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.isJiHoon){
                if(p.x == 0 || p.y == 0 || p.x == R - 1 || p.y == C - 1){
                    T = p.t + 1;
                    break;
                }
            }

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= R || dy >= C || map[dx][dy] == '#' || visited[dx][dy])
                    continue;
                queue.offer(new Point(dx, dy, p.t + 1, p.isJiHoon));
                visited[dx][dy] = true;
            }
        }
    }

}