package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, T, TMP, CNT;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] cheese;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(T + "\n" + CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        cheese = new char[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                cheese[i][j] = st.nextToken().charAt(0);
        }
        br.close();
    }

    static void process(){
        while(true){
            CNT = TMP;
            TMP = 0;
            visited = new boolean[N][M];
            bfs();
            if(TMP == 0)
                break;
            T++;
        }
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy])
                    continue;
                if(cheese[dx][dy] == '1') {
                    TMP++;
                    cheese[dx][dy] = '0';
                }
                else
                    queue.offer(new Pair(dx, dy));
                visited[dx][dy] = true;
            }
        }
    }

}