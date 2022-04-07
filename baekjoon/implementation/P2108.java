package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P2108 {

    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        preProcess();
        Arrays.sort(arr);
        process();
        System.out.println(sb);
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        double sum = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        sb.append((int)Math.round(sum / N)).append('\n');
        br.close();
    }

    static void process(){
        sb.append(arr[N / 2]).append('\n');

        int[] num = new int[8002];
        for(int i = 0; i < N; i++){
            if(arr[i] >= 0)
                num[arr[i] + 4001]++;
            else
                num[Math.abs(arr[i])]++;
        }

        int maxCnt = 0;
        for(int i = 1; i < 8002; i++)
            maxCnt = Math.max(maxCnt, num[i]);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 4000; i >= 1; i--){
            if(num[i] == maxCnt)
                list.add(i * -1);
        }

        for(int i = 4001; i < 8002; i++){
            if(num[i] == maxCnt)
                list.add(i - 4001);
        }

        sb.append(list.size() == 1 ? list.get(0) : list.get(1)).append('\n');
        sb.append(arr[N - 1] - arr[0]);
    }

}