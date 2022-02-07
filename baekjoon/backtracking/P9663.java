package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {

    static int N, CNT;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        backtracking(0);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        br.close();
    }

    static void writeOut(){
        System.out.println(CNT);
    }

    static void backtracking(int depth){
        if(depth == N){
            CNT++;
            return;
        }

        for(int i = 0; i < N; i++){
            arr[depth] = i;
            if(checkQueen(depth))
                backtracking(depth + 1);
        }
    }

    static boolean checkQueen(int col){
        for(int i = 0; i < col; i++){
            if(arr[col] == arr[i] || Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }

        return true;
    }

}