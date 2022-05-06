package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2847 {

    static int N, CNT;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        br.close();
    }

    static void process(){
        int tmp = arr[N - 1];
        for(int i = N - 2; i >= 0; i--){
            if(arr[i] >= tmp){
                CNT += arr[i] - (tmp - 1);
                tmp--;
            }else
                tmp = arr[i];
        }
    }

}