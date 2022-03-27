package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2751 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        br.close();
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(arr[i]).append('\n');
        System.out.println(sb);
    }

}