package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023 {

    private static int N, M;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException{
        readIn();
        boolean hasRelation = false;
        for(int i = 0; i < N; i++){
            if(dfs(0, i) >= 4){
                hasRelation = true;
                break;
            }
        }
        System.out.println(hasRelation ? "1" : "0");
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        adj = new ArrayList[N];
        for(int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        br.close();
    }

    public static int dfs(int depth, int dx){
        visited[dx] = true;

        int cnt = depth;
        for(int o : adj[dx]){
            if(cnt >= 4)
                return cnt;
            if(!visited[o])
                cnt = Math.max(cnt, dfs(depth + 1, o));
        }

        visited[dx] = false;
        return cnt;
    }

}