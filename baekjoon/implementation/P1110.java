package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1110 {

    static int N, CNT = 1;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    static void process(){
        if(N < 10)
            N *= 10;

        int dx = N % 10 * 10 + (N / 10 + N % 10) % 10;
        while(dx != N){
            dx = dx % 10 * 10 + (dx / 10 + dx % 10) % 10;
            CNT++;
        }
    }

}