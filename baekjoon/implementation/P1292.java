package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1292 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        int i = 1, dx = 1;
        boolean isFull = true;
        int[] arr = new int[1001];
        while(isFull){
            for(int j = 1; j <= i; j++) {
                if(dx > 1000){
                    isFull = false;
                    break;
                }
                arr[dx++] = i;
            }
            i++;
        }

        int sum = 0;
        for(int j = a; j <= b; j++)
            sum += arr[j];

        System.out.println(sum);
        br.close();
    }

}