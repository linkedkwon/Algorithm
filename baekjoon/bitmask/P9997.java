package baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9997 {

    static int N, CNT;
    static int sample;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        preProcess();
        dfs(0, 0);
        System.out.println(CNT);
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int len = str.length(), num = 0;
            for(int j = 0; j < len; j++){
                num |= (1 << (str.charAt(j) - 97));
            }
            arr[i] = num;
        }

        for(int i = 0; i < 26; i++)
            sample |= (1 << i);

        br.close();
    }

    static void dfs(int depth, int mask){
        if(sample == mask) {
            CNT++;
        }
        if(depth == N)
            return;

        for(int i = depth; i < N; i++){
            dfs(i + 1, mask | arr[i]);
        }
    }

}