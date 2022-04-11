package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1550 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length(), num = 0, dx = 0;
        for(int i = len - 1; i >= 0; i--){
            char c = str.charAt(i);
            int dy = c >= 65 ? c - 55 : c - '0';
            num += Math.pow(16, dx++) * dy;
        }

        System.out.println(num);
        br.close();
    }

}