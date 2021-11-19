package baekjoon.topological_sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N + 1];
        ArrayList<Integer>[] adj = new ArrayList[N + 1];

        for(int i = 1; i < adj.length; i++)
            adj[i] = new ArrayList<Integer>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
            inDegree[v2]++;
            adj[v1].add(v2);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < inDegree.length; i++){
            if(inDegree[i] == 0)
                queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int v = queue.poll();
            sb.append(v + " ");
            for(int i : adj[v]) {
                inDegree[i]--;
                if(inDegree[i] == 0)
                    queue.offer(i);
            }
        }

        System.out.println(sb);
        br.close();
    }
}