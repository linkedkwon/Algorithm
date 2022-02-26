package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1167 {

    static class Pair{
        int v, dist;

        public Pair(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    static int N, MAX, NODE;
    static boolean[] visited;
    static ArrayList<Pair>[] adj;

    public static void main(String[] args) throws IOException{
        readIn();
        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(NODE, 0);

        System.out.println(MAX);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy;
            while((dy = Integer.parseInt(st.nextToken()))!= -1){
                int dist = Integer.parseInt(st.nextToken());
                adj[dx].add(new Pair(dy, dist));
            }
        }
        br.close();
    }

    static void dfs(int v, int sum) {
        if (sum > MAX) {
            MAX = sum;
            NODE = v;
        }
        visited[v] = true;

        for(Pair p : adj[v]) {
            if (!visited[p.v])
                dfs(p.v, sum + p.dist);
        }
    }

}