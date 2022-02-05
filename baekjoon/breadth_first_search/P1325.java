package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325 {

    private static int N, M, MAX = 0;
    private static int[] cnt;
    private static ArrayList<Integer>[] adj;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 1; i <= N; i++)
            MAX = Math.max(MAX, cnt[i] = bfs(i));

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(cnt[i] == MAX)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        cnt = new int[N + 1];

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            adj[y].add(x);
        }

        br.close();
    }

    public static int bfs(int node){
        boolean[] visited = new boolean[N + 1];
        visited[node] = true;
        queue.offer(node);

        int cnt = 0;
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for (int e : adj[v]) {
                if (!visited[e]) {
                    queue.offer(e);
                    visited[e] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

}