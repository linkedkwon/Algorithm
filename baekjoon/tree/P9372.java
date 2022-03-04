package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9372 {

    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            readIn();
            sb.append(N - 1).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    static void readIn() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
        }
    }

}