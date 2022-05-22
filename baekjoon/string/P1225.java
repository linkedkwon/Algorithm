package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1225 {

    static long N, SUM;
    static String A, B;

    public static void main(String[] args) throws IOException{
        readIn();
        setOperand();
        process();
        System.out.println(SUM);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken(); B = st.nextToken();
        br.close();
    }

    static void setOperand(){
        int len = B.length();
        for(int i = 0; i < len; i++)
            N += (B.charAt(i) - '0');
    }

    static void process(){
        int len = A.length();
        for(int i = 0; i < len; i++)
            SUM += N * (A.charAt(i) - '0');
    }

}