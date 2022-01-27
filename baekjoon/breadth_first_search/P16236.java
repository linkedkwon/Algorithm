package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16236 {

    private static class Point{
        int x;
        int y;
        int t;

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static PriorityQueue<Point> heap = new PriorityQueue<>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.t == o2.t){
                if(o1.x == o2.x) return o1.y - o2.y;
                else return o1.x - o2.x;
            }
            return o1.t - o2.t;
        }
    });

    private static int N, dx, dy, T = 0, eatingCnt = 0, size = 2;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        System.out.println(T);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int state = Integer.parseInt(st.nextToken());
                map[i][j] = state;
                if(state == 9) {
                    map[i][j] = 0;
                    heap.add(new Point(i, j, 0));
                    dx = i; dy = j;
                }
            }
        }

        br.close();
    }

    public static void bfs(){
        boolean[][] visited = new boolean[N][N];
        visited[dx][dy] = true;

        while(!heap.isEmpty()) {
            Point p = heap.poll();

            if (map[p.x][p.y] != 0 && map[p.x][p.y] < size) {
                map[p.x][p.y] = 0;
                eatingCnt++;
                if (eatingCnt == size) {
                    eatingCnt = 0;
                    size++;
                }

                T += p.t;
                p.t = 0;
                heap.clear();
                visited = new boolean[N][N];
            }

            for (int d = 0; d < 4; d++) {
                int dx = p.x + x[d], dy = p.y + y[d];
                if (dx < 0 || dy < 0 || dx >= N || dy >= N)
                    continue;
                if (map[dx][dy] > size || visited[dx][dy])
                    continue;

                heap.add(new Point(dx, dy, p.t + 1));
                visited[dx][dy] = true;
            }
        }
    }

}