package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2023 {

    static int N;
    static int[] prime = {2, 3, 5, 7};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < 4; i++)
            dfs(1, prime[i]);
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

    static void dfs(int depth, int num){
        if(!isPrime(num))
            return;
        if(depth == N){
            sb.append(num).append('\n');
            return;
        }
        for(int i = 0; i <= 9; i++)
            dfs(depth + 1, num * 10 + i);
    }

}