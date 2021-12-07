package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1068 {

    private static ArrayList<Integer>[] adj;
    private static int delNode;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N];
        for(int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> root = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int dx = Integer.parseInt(st.nextToken());
            if(dx == -1) {
                root.add(i);
                continue;
            }
            adj[dx].add(i);
        }

        delNode = Integer.parseInt(br.readLine());
        for(int o : root) {
            if(delNode != o)
                dfs(o);
        }

        System.out.println(cnt);
        br.close();
    }

    public static void dfs(int dx){
        boolean flag = false;
        for(int o : adj[dx]) {
            if(o == delNode)
                continue;
            dfs(o);
            flag = true;
        }

        if(!flag)
            cnt++;
    }
}