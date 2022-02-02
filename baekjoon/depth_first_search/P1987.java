package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1987 {

    private static class Node{
        int x, w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    private static int N, max = 0, dx = 0;
    private static boolean[] visited;
    private static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException{
        readIn();
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N + 1];
        visited[dx] = true;
        dfs(dx, 0);
        System.out.println(max);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            adj[x].add(new Node(y, w)); adj[y].add(new Node(x, w));
        }

        br.close();
    }

    public static void dfs(int node, int len){
        if(max < len){
            max = len;
            dx = node;
        }

        for(Node e : adj[node]){
            if(!visited[e.x]) {
                visited[node] = true;
                dfs(e.x, len + e.w);
            }
        }
    }

}