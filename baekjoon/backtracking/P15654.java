package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15654 {

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        readIn();
        Arrays.sort(arr);
        dfs(0, new int[M]);
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void dfs(int depth, int[] tmp){
        if(depth == M){
            for(int i = 0; i < M; i++)
                sb.append(tmp[i]).append(' ');
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                dfs(depth + 1, tmp);
                visited[i] = false;
            }
        }
    }

}