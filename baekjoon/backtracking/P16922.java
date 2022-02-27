package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16922 {

    static int N, CNT;
    static int[] arr = {1, 5, 10, 50};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < 4; i++)
            dfs(1, arr[i]);
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][1001];
        br.close();
    }

    static void dfs(int depth, int sum){
        if(depth == N){
            CNT++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(!visited[depth][sum + arr[i]]) {
                visited[depth][sum + arr[i]] = true;
                dfs(depth + 1, sum + arr[i]);
            }
        }
    }

}