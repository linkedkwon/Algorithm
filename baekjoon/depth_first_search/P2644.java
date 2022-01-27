package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2644 {

    private static int N, start, end, kinship;
    private static boolean[] visited;
    private static ArrayList<Integer>[] relation;

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(start, 1);
        System.out.println(kinship == 0 ? -1 : kinship);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        relation = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            relation[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            relation[x].add(y);
            relation[y].add(x);
        }

        br.close();
    }

    public static void dfs(int node, int cnt){
        if(kinship != 0)
            return;
        visited[node] = true;

        for(int o: relation[node]){
            if(o == end) {
                kinship = cnt;
                return;
            }
            if(!visited[o])
                dfs(o, cnt + 1);
        }
    }

}