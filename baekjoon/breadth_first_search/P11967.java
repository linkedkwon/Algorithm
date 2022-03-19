package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11967 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static char[][] arr;
    static ArrayList<Pair>[] list;

    public static void main(String[] args) throws IOException {
        readIn();
        process();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new char[N + 1][N + 1]; list = new ArrayList[N * N + 1];
        arr[1][1] = '1';
        for(int i = 1; i <= N * N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
                x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
            int dx = (x1 - 1) * N + y1;
            list[dx].add(new Pair(x2, y2));
        }

        for(Pair p : list[1])
            arr[p.x][p.y] = '1';
        br.close();
    }

    static void process(){
        int movedCnt= 0;
        while(true){
            int tmp = bfs();
            if(movedCnt == bfs())
                break;
            movedCnt = tmp;
        }
    }

    static int bfs(){
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 1));
        visited[1][1] = true;
        int movedCnt = 1;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 1 || dy < 1 || dx > N || dy > N || arr[dx][dy] != '1' || visited[dx][dy])
                    continue;

                int idx = (dx - 1) * N + dy;
                for(Pair obj : list[idx])
                    arr[obj.x][obj.y] = '1';

                queue.offer(new Pair(dx, dy));
                visited[dx][dy] = true;
                movedCnt++;
            }
        }

        return movedCnt;
    }

    static void writeOut(){
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(arr[i][j] == '1')
                    cnt++;
            }
        }
        System.out.println(cnt);
    }

}