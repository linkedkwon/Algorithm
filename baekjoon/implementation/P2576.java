package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2576 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE, sum = 0;

        for(int i = 0; i < 7; i++){
            int n = Integer.parseInt(br.readLine());
            if(n % 2 != 0){
                sum += n;
                min = Math.min(min, n);
            }
        }

        System.out.println(sum == 0 ? "-1" : sum + "\n" + min);
        br.close();
    }

}