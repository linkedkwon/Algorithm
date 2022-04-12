package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10817 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        int min = 101, max = 0;
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] < min) min = Math.min(min, arr[i]);
            if(arr[i] > max) max = Math.max(max, arr[i]);
        }

        for(int i = 0; i < 3; i++){
            if(arr[i] == min) {
                min = 101;
                continue;
            }
            if(arr[i] == max) {
                max = 101;
                continue;
            }
            System.out.println(arr[i]);
        }
        br.close();
    }

}