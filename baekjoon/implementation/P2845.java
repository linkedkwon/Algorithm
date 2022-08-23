package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2845 {

    static int cnt;
    static int[] arr = new int[5];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        System.out.println(sb);
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void process(){
        for(int e : arr)
            sb.append((e - cnt)).append(' ');
    }

}