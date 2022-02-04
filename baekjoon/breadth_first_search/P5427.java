package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5427 {

    private static class Point{
        int x, y, t;
        boolean isFire;

        public Point(int x, int y, int t, boolean isFire) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.isFire = isFire;
        }
    }

    private static int W, H;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static char[][] map;
    private static boolean[][] visited;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            readIn();
            int time = bfs();
            sb.append(time == -1 ? "IMPOSSIBLE" : time).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void readIn() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken());
        map = new char[W][H];
        visited = new boolean[W][H];
        queue = new LinkedList<>();

        int dx = 0, dy = 0;
        for(int i = 0; i < W; i++){
            String str = br.readLine();
            for(int j = 0; j < H; j++){
                char c = str.charAt(j);
                map[i][j] = c;
                if(c == '@'){
                    dx = i; dy = j;
                }else if(c == '*'){
                    queue.offer(new Point(i, j, 0, true));
                }
            }
        }

        queue.offer(new Point(dx, dy, 0, false));
        visited[dx][dy] = true;
    }

    public static int bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(!p.isFire) {
                if (p.x == 0 || p.y == 0 || p.x == W - 1 || p.y == H - 1)
                    return p.t + 1;
            }

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= W || dy >= H || visited[dx][dy] || map[dx][dy] != '.')
                    continue;
                queue.offer(new Point(dx, dy, p.t + 1, p.isFire));
                visited[dx][dy] = true;
            }
        }

        return -1;
    }

}