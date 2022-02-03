package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3184 {

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int R, C, sheep, wolf;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static char[][] yard;
    private static boolean[][] visited;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j] && yard[i][j] != '#'){
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                    bfs();
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];
        yard = new char[R][C];
        for(int i = 0; i < R; i++)
            yard[i] = br.readLine().toCharArray();

        queue = new LinkedList<>();
        br.close();
    }

    public static void bfs(){
        int s = 0, w = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            char c = yard[p.x][p.y];
            if(c == 'v') w++;
            else if(c == 'o') s++;

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= R || dy >= C ||visited[dx][dy] || yard[dx][dy] == '#')
                    continue;
                visited[dx][dy] = true;
                queue.offer(new Point(dx, dy));
            }
        }

        if(s > w) sheep += s;
        else wolf += w;
    }

}