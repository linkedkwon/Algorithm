package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {

    public static class Point{
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static int T, L, endX, endY, cnt;
    private static int[] x = {-1, -2, 1, 2, -2, -1, 1, 2}, y = {-2, -1, -2, -1, 1, 2, 2, 1};
    private static boolean[][] visited;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        init();
        for(int t = 0; t < T; t++){
            readIn();
            bfs();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void init() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
    }

    public static void readIn() throws IOException{
        L = Integer.parseInt(br.readLine());
        visited = new boolean[L][L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        visited[x][y] = true;

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken()); endY = Integer.parseInt(st.nextToken());
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.x == endX && p.y == endY) {
                cnt = p.cnt;
                break;
            }

            for(int d = 0; d < 8; d++){
               int dx = p.x + x[d], dy = p.y + y[d];
               if(dx < 0 || dy < 0 || dx >= L || dy >= L)
                   continue;
               if(!visited[dx][dy]){
                   queue.offer(new Point(dx, dy, p.cnt + 1));
                   visited[dx][dy] = true;
               }
            }
        }
    }

}