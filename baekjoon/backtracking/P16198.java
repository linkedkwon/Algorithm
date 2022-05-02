package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16198 {

    static int N, MAX;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        backtracking(0, 0);
        System.out.println(MAX);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void backtracking(int depth, int sum){
        if(N - depth < 3) {
            MAX = Math.max(MAX, sum);
            return;
        }

        for(int i = 1; i < N - 1; i++){
            if(visited[i]) continue;
            visited[i] = true;
            backtracking(depth + 1, sum + getSideMulti(i));
            visited[i] = false;
        }
    }

    static int getSideMulti(int dx){
        int left = 0;
        for(int i = dx; i >= 0; i--){
            if(!visited[i]){
                left = arr[i];
                break;
            }
        }

        int right = 0;
        for(int i = dx; i < N; i++){
            if(!visited[i]){
                right = arr[i];
                break;
            }
        }
        return left * right;
    }

}