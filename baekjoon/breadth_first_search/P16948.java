package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16948 {

    static class Pair{
        int x, y, cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N, r1, c1, r2, c2;
    static int CNT = -1;
    static int[] x = {-2, -2, 0, 0, 2, 2}, y = {-1, 1, -2, 2, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()); c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken()); c2 = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];

        br.close();
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(r1, c1, 0));
        visited[r1][c1] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.x == r2 && p.y == c2){
                CNT = p.cnt;
                return;
            }
            for(int d = 0; d < 6; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= N || visited[dx][dy])
                    continue;
                visited[dx][dy] = true;
                queue.offer(new Pair(dx, dy, p.cnt + 1));
            }
        }
    }

}