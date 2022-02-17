package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559 {

    static int N, K, MAX;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        tp();
        System.out.println(MAX);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void tp(){
        int dx = 0, dy = K - 1, sum = 0;
        for(int i = dx; i <= dy; i++)
            sum += arr[i];
        MAX = sum;

        while(dy < N - 1){
            sum += arr[++dy] - arr[dx++];
            MAX = Math.max(MAX, sum);
        }
    }

}