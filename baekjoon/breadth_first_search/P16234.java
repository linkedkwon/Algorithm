package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16234 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, R, L, DAY = 0;
    static boolean hasNext = true;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static int[][] arr, clone;
    static boolean[][] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        readIn();
        while(hasNext) {
            hasNext = false;
            visited = new boolean[N][N];
            clone = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }
            appendArray();
            DAY++;
        }
        System.out.println(DAY - 1);
    }

    static void readIn() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); L = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static void bfs(int i, int j){
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Pair> list = new ArrayList<>();
        queue.offer(new Pair(i, j));

        int cnt = 1, sum = arr[i][j];
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            list.add(new Pair(p.x, p.y));

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= N || visited[dx][dy])
                    continue;
                int dif = Math.abs(arr[p.x][p.y] - arr[dx][dy]);
                if(dif >= L && dif <= R){
                    queue.offer(new Pair(dx, dy));
                    sum += arr[dx][dy];
                    visited[dx][dy] = true;
                    cnt++;
                }
            }
        }

        if(cnt == 1)
            return;
        hasNext = true;
        int avg = sum / cnt;
        for(Pair p : list)
            clone[p.x][p.y] = avg;
    }

    static void appendArray(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(clone[i][j] != 0)
                    arr[i][j] = clone[i][j];
            }
        }
    }

}