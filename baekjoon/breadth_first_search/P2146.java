package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2146 {

    static class Pair{
        int x, y, len, color;

        public Pair(int x, int y, int len, int color) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.color = color;
        }
    }

    static int N, order = 2, LEN = Integer.MAX_VALUE;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static int[][] map, visited;

    public static void main(String[] args) throws IOException{
        readIn();
        divideIsland();
        getMinimumLen();
        System.out.println(LEN - 1);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static void divideIsland(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1) {
                    map[i][j] = order;
                    preBfs(i, j);
                    order++;
                }
            }
        }
    }

    static void getMinimumLen(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != 0)
                    postBfs(i, j);
            }
        }
    }

    static void preBfs(int r, int c){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(r, c, 0, 0));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= N)
                    continue;
                if(map[dx][dy] != 1 || map[dx][dy] == order)
                    continue;
                map[dx][dy] = order;
                queue.offer(new Pair(dx, dy, 0, 0));
            }
        }
    }

    static void cloneArray(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                visited[i][j] = map[i][j];
            }
        }
    }

    static void postBfs(int r, int c){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(r, c, 0, map[r][c]));
        visited = new int[N][N];
        cloneArray();

        int color = map[r][c];
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.color != color){
                LEN = Math.min(LEN, p.len);
                break;
            }

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= N || visited[dx][dy] == color)
                    continue;

                int tmp = visited[dx][dy] == 0 ? color : visited[dx][dy];
                queue.offer(new Pair(dx, dy, p.len + 1, tmp));
                visited[dx][dy] = color;
            }
        }
    }

}