package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P2668 {

    private static int N, parent;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adj;
    private static ArrayList<Integer> nodes;

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 1; i <= N; i++){
            parent = i;
            visited = new boolean[N + 1];
            if(dfs(i))
                nodes.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nodes.size()).append("\n");
        for(int o : nodes)
            sb.append(o).append("\n");

        System.out.println(sb);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
            adj[i].add(Integer.parseInt(br.readLine()));
        }

        nodes = new ArrayList<>();
        br.close();
    }

    public static boolean dfs(int dx){
        boolean hasCycle = false;
        visited[dx] = true;

        for(int o : adj[dx]){
            if(o == parent)
                return true;
            if(!visited[o])
                hasCycle = dfs(o);
        }

        return hasCycle;
    }

}