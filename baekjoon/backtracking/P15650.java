package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650 {

    static int N, M;
    static int[] node;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(1);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        node = new int[M + 1];

        br.close();
    }

    static void writeOut(){
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth > M){
            for(int m = 1; m <= M; m++)
                sb.append(node[m]).append(" ");
            sb.append("\n");
            return;
        }

        for(int n = node[depth - 1] + 1; n <= N; n++){
            node[depth] = n;
            dfs(depth + 1);
        }
    }

}