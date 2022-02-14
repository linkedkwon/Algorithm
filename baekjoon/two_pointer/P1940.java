package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940 {

    static int N, M, CNT;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        getArmorCount();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); M = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void getArmorCount(){
        int dx = 0, dy = N - 1;
        while(dx != dy){
            int sum = arr[dx] + arr[dy];
            if(sum < M){
                dx++;
            }else if(sum == M){
                CNT++;
                dy--;
            }else {
                dy--;
            }
        }
    }

}