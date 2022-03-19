package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14716 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int M, N, CNT;
    static int[] x = {-1, 1, 0, 0, -1, 1, 1, -1}, y = {0, 0, -1, 1, -1, -1, 1, 1};
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        arr = new char[M][N]; visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                arr[i][j] = st.nextToken().charAt(0);
        }
        br.close();
    }

    static void process(){
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == '1' && !visited[i][j]){
                    bfs(i, j);
                    CNT++;
                }
            }
        }
    }

    static void bfs(int i, int j){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d = 0; d < 8; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= M || dy >= N || visited[dx][dy] || arr[dx][dy] == '0')
                    continue;
                queue.offer(new Pair(dx, dy));
                visited[dx][dy] = true;
            }
        }
    }

}