package baekjoon.disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717 {

    static int N, M;
    static int[] root;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        root = new int[N + 1];

        for(int i = 1; i <= N; i++)
            root[i] = i;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()),
                b = Integer.parseInt(st.nextToken());

            switch(op){
                case 0: union(a, b); break;
                case 1: sb.append(checkSameRoot(a, b)? "YES" : "NO").append('\n'); break;
            }
        }

        System.out.println(sb);
        br.close();
    }

    static int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y) root[y] = x;
            else root[x] = y;
        }
    }

    static boolean checkSameRoot(int x, int y){
        x = find(x);
        y = find(y);

        return x == y ? true : false;
    }

}