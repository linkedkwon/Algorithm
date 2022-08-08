package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2953 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int j = 0; j < 4; j++)
                sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        int dx = 0, max = arr[0];
        for(int i = 1; i < 5; i++){
           if(arr[i] > max){
               max = arr[i];
               dx = i;
           }
        }

        System.out.println(dx + 1 + " " + max);
        br.close();
    }

}