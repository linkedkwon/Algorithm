package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2522 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        printStar(N - 1, 1, true);
        printStar(1, N - 1, false);
        System.out.println(sb);
        br.close();
    }

    static void printStar(int dx, int dy, boolean type){
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < dx; j++)
                sb.append(' ');
            for(int k = 0; k < dy; k++)
                sb.append('*');

            sb.append('\n');
            if(type) {dx--; dy++;}
            else {dx++; dy--;}
        }
    }

}