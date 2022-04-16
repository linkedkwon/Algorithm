package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2577 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine()), B = Integer.parseInt(br.readLine()), C = Integer.parseInt(br.readLine());
        int mul = A * B * C;
        int[] arr = new int[10];

        while(mul > 0){
            arr[mul % 10]++;
            mul /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++)
            sb.append(arr[i]).append('\n');

        System.out.println(sb);
        br.close();
    }

}