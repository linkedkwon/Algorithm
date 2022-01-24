package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {

    public static class Point{
        int x;
        int y;
        int z;
        int day;

        public Point(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    private static int M, N, H;
    private static boolean hasRipen = true;
    private static char[][][] box;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{

        read();
        if(hasRipen)
            System.out.println("0");
        else
            bfs();
    }

    public static void read() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());

        box = new char[H][N][M];
        queue = new LinkedList<>();
        for(int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    char c = st.nextToken().charAt(0);
                    box[h][n][m] = c;

                    if(c == '0')
                        hasRipen = false;
                    else if(c == '1')
                        queue.offer(new Point(h, n, m, 0));
                }
            }
        }

        br.close();
    }

    public static void bfs(){
        int day = 0;
        int[] x = {-1, 1, 0, 0, 0, 0}, y = {0, 0, -1, 1, 0, 0}, z = {0, 0, 0, 0, -1, 1};
        boolean[][][] visited = new boolean[H][N][M];

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int d = 0; d < 6; d++){
                int dx = p.x + x[d], dy = p.y + y[d], dz = p.z + z[d];

                if(dx < 0 || dy < 0 || dz < 0 || dx >= H || dy >= N || dz >= M)
                    continue;
                if(box[dx][dy][dz] == '0' && !visited[dx][dy][dz]) {
                    box[dx][dy][dz] = '1';
                    day = p.day + 1;
                    queue.offer(new Point(dx, dy, dz, day));
                    visited[dx][dy][dz] = true;
                }
            }
        }

        System.out.println(checkAllHasRipen() ? day : "-1");
    }

    public static boolean checkAllHasRipen(){
        boolean hasRipen = true;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(box[i][j][k] == '0') {
                        hasRipen = false;
                        break;
                    }
                }
            }
        }

        return hasRipen;
    }

}