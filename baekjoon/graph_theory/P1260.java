package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
        int[][] adj = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken());
            adj[dx][dy] = adj[dy][dx] = 1;
        }

        //1. depth for search by stack
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(V);

        while(!stack.isEmpty()){
            int dx = stack.pop();
            if(visited[dx])
                continue;
            visited[dx] = true;
            sb.append(dx + " ");

            for(int i = N; i >= 1; i--){
                if(adj[dx][i] == 1 && !visited[i])
                    stack.push(i);
            }
        }

        sb.append("\n");

        //2. breath first search by queue
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while(!queue.isEmpty()){
            int dx = queue.poll();
            sb.append(dx + " ");

            for(int i = 1; i <= N; i++){
                if(adj[dx][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    //3. depth first search by recursion
    private static int len = 5;
    private static boolean[] visited = new boolean[len];
    private static int[][] adj = new int[len][len];

    public static void dfs(int v){
        visited[v] = true;

        for(int i = 1; i < len; i++){
            if(adj[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

}