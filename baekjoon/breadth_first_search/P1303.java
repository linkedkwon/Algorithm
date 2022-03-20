package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1303 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, wCNT, bCNT;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(wCNT + " " + bCNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());

        arr = new char[N][M]; visited = new boolean[N][M];
        for(int i = 0; i < N; i++)
            arr[i] = br.readLine().toCharArray();

        br.close();
    }

    static void process(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j])
                    bfs(i, j);
            }
        }
    }

    static void bfs(int i, int j){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        visited[i][j] = true;

        char team = arr[i][j];
        int W = 0, B = 0;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(arr[p.x][p.y] == 'W') W++;
            else B++;

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy] || arr[dx][dy] != team)
                    continue;
                queue.offer(new Pair(dx, dy));
                visited[dx][dy] = true;
            }
        }

        if(team == 'W') wCNT += Math.pow(W, 2);
        else bCNT += Math.pow(B, 2);
    }

}