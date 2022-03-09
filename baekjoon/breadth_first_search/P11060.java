package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11060 {

    static class Pair{
        int dx, cnt;

        public Pair(int dx, int cnt) {
            this.dx = dx;
            this.cnt = cnt;
        }
    }
    static int N, CNT = -1;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        visited[0] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.dx == N - 1){
                CNT = p.cnt;
                break;
            }
            for(int i = 1; i <= arr[p.dx]; i++){
                int dx = p.dx + i;
                if(dx < 0 || dx >= N || visited[dx])
                    continue;
                queue.offer(new Pair(dx, p.cnt + 1));
                visited[dx] = true;
            }
        }
    }

}