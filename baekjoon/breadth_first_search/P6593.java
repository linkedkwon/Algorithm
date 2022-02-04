package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6593 {

    private static class Point{
        int x, y, z, t;

        public Point(int x, int y, int z, int t) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.t = t;
        }
    }

    private static int L, R, C;
    private static char[][][] map;
    private static int[] x = {-1, 1, 0, 0, 0, 0}, y = {0, 0, -1, 1, 0, 0}, z = {0, 0, 0, 0, -1, 1};
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0)
                break;

            map = new char[L][R][C];
            queue = new LinkedList<>();
            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    String read = br.readLine();
                    for(int k = 0; k < C; k++){
                        char c = read.charAt(k);
                        map[i][j][k] = c;
                        if(c == 'S') {
                            queue.offer(new Point(i, j, k, 0));
                            map[i][j][k] = '#';
                        }
                    }
                }
                br.readLine();
            }

            int t = bfs();
            sb.append(t == -1 ? "Trapped!" : "Escaped in " + t + " minute(s).").append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int d = 0; d < 6; d++){
                int dx = p.x + x[d], dy = p.y + y[d], dz = p.z + z[d];
                if(dx < 0 || dy < 0 || dz < 0 || dx >= L || dy >= R || dz >= C || map[dx][dy][dz] == '#')
                    continue;
                if(map[dx][dy][dz] == 'E')
                    return p.t + 1;

                queue.offer(new Point(dx, dy, dz, p.t + 1));
                map[dx][dy][dz] = '#';
            }
        }
        return -1;
    }

}