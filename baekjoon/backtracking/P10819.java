package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10819 {

    static int N, MAX;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        preProcess();
        dfs(0, new int[N]);
        System.out.println(MAX);
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void dfs(int depth, int[] tmp){
        if(depth == N){
            int sum = 0;
            for(int i = 0; i < N - 1; i++)
                sum += Math.abs(tmp[i] - tmp[i + 1]);

            MAX = Math.max(MAX, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = arr[i];
                dfs(depth + 1, tmp);
                visited[i] = false;
            }
        }
    }

}
