package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4344 {

    static int N;
    static int avg;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            readIn();
            getPercentOverAvg();
        }
        System.out.println(sb);
        br.close();
    }

    static void readIn() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        avg = sum / N;
    }

    static void getPercentOverAvg(){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(avg < arr[i])
                cnt++;
        }

        double per = cnt / (double)N * 100;
        sb.append(String.format("%.3f", per)).append('%').append('\n');
    }

}