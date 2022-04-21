package baekjoon.disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976 {

    static int[] root;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        root = new int[N + 1];
        for(int i = 1; i <= N; i++)
            root[i] = i;

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                if(Integer.parseInt(st.nextToken()) == 1)
                    union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        boolean hasSameRoot = true;
        while(st.hasMoreTokens()){
            if(start != find(Integer.parseInt(st.nextToken()))) {
                hasSameRoot = false;
                break;
            }
        }

        System.out.println(hasSameRoot ? "YES" : "NO");
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

}