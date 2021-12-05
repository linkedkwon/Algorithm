package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BFS version
public class P11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for(int i = 0; i < adj.length; i++)
            adj[i] = new ArrayList<>();

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken());
            adj[dx].add(dy);
            adj[dy].add(dx);
        }

        int[] pArr = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        pArr[1] = -1;

        while(!queue.isEmpty()){
            int pNode = queue.poll();
            for(int i : adj[pNode]){
                if(pArr[i] == 0) {
                    pArr[i] = pNode;
                    queue.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < N + 1; i++)
            sb.append(pArr[i]+"\n");
        System.out.println(sb);
        br.close();
    }
}