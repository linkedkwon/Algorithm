package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3055 {

    public static class Point{
        int x, y, t;
        boolean isHedehog;

        public Point(int x, int y, int t, boolean isHedehog) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.isHedehog = isHedehog;
        }
    }

    private static int R, C;
    private static char[][] map;
    private static boolean[][] visited;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        readIn();
        int t = bfs();
        System.out.println(t == 0 ? "KAKTUS" : t);
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
                if(c == '*') {
                    queue.add(new Point(i, j, 0, false));
                    visited[i][j] = true;
                }
                else if(c == 'S'){
                    dx = i; dy = j;
                }
            }
        }

        queue.add(new Point(dx, dy, 0, true));
        visited[dx][dy] = true;
        br.close();
    }

    public static int bfs(){
        int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};

        int time = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.isHedehog && map[p.x][p.y] == 'D') {
                time = p.t;
                break;
            }

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= R || dy >= C || visited[dx][dy] || map[dx][dy] == 'X')
                    continue;

                if(!p.isHedehog){
                    if(map[dx][dy] == 'D')
                        continue;
                    map[dx][dy] = '*';
                    queue.offer(new Point(dx, dy, 0, false));
                }else{
                    if(map[dx][dy] == '*')
                        continue;
                    queue.offer(new Point(dx, dy, p.t + 1, true));
                }
                visited[dx][dy] = true;
            }
        }

        return time;
    }

}