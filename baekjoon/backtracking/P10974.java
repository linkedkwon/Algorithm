package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10974 {

    static int N;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        permutateNum(0);
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        used = new boolean[N + 1];
        br.close();
    }

    static void permutateNum(int depth){
        if(depth == N){
            for(int i = 0; i < N; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!used[i]) {
                arr[depth] = i;
                used[i] = true;
                permutateNum(depth + 1);
                used[i] = false;
            }
        }
    }

}