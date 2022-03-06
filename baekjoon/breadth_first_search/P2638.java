package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2638 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, DAY;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static boolean hasNext = true;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        readIn();
        while(hasNext){
            hasNext = false;
            visited = new boolean[N][M];
            bfs();
            meltCheese();
            DAY++;
        }
        System.out.println(DAY);
    }

    static void readIn() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = st.nextToken().charAt(0);
        }
        br.close();
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy] || arr[dx][dy] == '1')
                    continue;
                queue.offer(new Pair(dx, dy));
                visited[dx][dy] = true;
            }
        }
    }

    static void meltCheese(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int cnt = 0;
                if(arr[i][j] == '1'){
                    for(int d = 0; d < 4; d++){
                        int dx = i + x[d], dy = j + y[d];
                        if(visited[dx][dy])
                            cnt++;
                    }
                    if(cnt > 1)
                        arr[i][j] = '0';
                    else
                        hasNext = true;
                }
            }
        }
    }

}