package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724 {

    private static int N, M;
    private static ArrayList<Integer>[] adj;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        preProcess();

        int linkedCnt = 0;
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                visited[i] = true;
                linkedCnt += dfs(i);
            }
        }

        System.out.println(linkedCnt);
    }

    public static void preProcess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        br.close();
    }

    public static int dfs(int node){
        for(int o : adj[node]){
            if(!visited[o]){
                visited[o] = true;
                dfs(o);
            }
        }

        return 1;
    }

}