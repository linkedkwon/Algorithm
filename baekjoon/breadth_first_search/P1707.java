package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707 {

    private static int K, V, E;
    private static ArrayList<Integer>[] adj;
    private static int[] visited;
    private static Queue<Integer> queue;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++){
            readIn();
            boolean answer = true;
            for(int i = 1; i <= V; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(i);
                    answer = bfs();
                }
                if(!answer)
                    break;
            }
            sb.append(answer ? "YES":"NO").append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void readIn() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());

        visited = new int[V + 1];
        adj = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        queue = new LinkedList<>();
    }

    public static boolean bfs(){
        while(!queue.isEmpty()){
            int e = queue.poll();
            int val = visited[e];
            for(int o : adj[e]){
                if(visited[o] == val){
                    return false;
                }else if(visited[o] == 0){
                    queue.add(o);
                    visited[o] = val == 1 ? 2 : 1;
                }
            }
        }
        return true;
    }
}