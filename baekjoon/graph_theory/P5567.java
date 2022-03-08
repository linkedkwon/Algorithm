package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5567 {

    static class Pair{
        int o, cnt;

        public Pair(int o, int cnt) {
            this.o = o;
            this.cnt = cnt;
        }
    }
    static int N, CNT;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
        br.close();
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 0));
        visited[1] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int e : adj[p.o]){
                if(visited[e] || p.cnt > 1)
                    continue;
                visited[e] = true;
                queue.offer(new Pair(e, p.cnt + 1));
                CNT++;
            }
        }
    }

}