package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8595 {

    static int N;
    static long SUM;
    static String str;

    public static void main(String[] args) throws IOException{
        readIn();
        parseStr();
        System.out.println(SUM);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        br.close();
    }

    static void parseStr(){
        int appended = 0;
        for(int i = 0; i < N; i++){
            char c = str.charAt(i);
            if(c >= 48 && c <= 57){
                appended *= 10;
                appended += c - '0';
            }else{
                SUM += appended;
                appended = 0;
            }
        }
        SUM += appended;
    }

}