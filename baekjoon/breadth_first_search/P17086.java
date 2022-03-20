package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17086 {

    static class Pair{
        int x, y, d;

        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int N, M, MAX;
    static int[] x = {-1, 1, 0, 0, -1, 1, 1, -1}, y = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(MAX);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static void process(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited = new boolean[N][M];
                if(arr[i][j] == 0)
                    bfs(i, j);
            }
        }
    }

    static void bfs(int i, int j){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j, 1));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d = 0; d < 8; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy])
                    continue;
                if(arr[dx][dy] == 1){
                    MAX = Math.max(MAX, p.d);
                    return;
                }
                queue.offer(new Pair(dx, dy, p.d + 1));
                visited[dx][dy] = true;
            }
        }
    }

}