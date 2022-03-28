package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14490 {

    static int N, M, gcd;
    static String str;

    public static void main(String[] args) throws IOException{
        readIn();
        parseStr();
        getGcd();
        System.out.println(N / gcd + ":" + M / gcd);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        br.close();
    }

    static void parseStr(){
        String[] arr = str.split(":");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
    }

    static void getGcd(){
        int min = Math.min(N, M);
        for(int i = 1; i <= min; i++){
            if(N % i == 0 && M % i == 0)
                gcd = i;
        }
    }

}