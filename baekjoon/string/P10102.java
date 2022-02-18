package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10102 {

    static int N, A, B;
    static String str;

    public static void main(String[] args) throws IOException{
        readIn();
        getVote();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        br.close();
    }

    static void getVote(){
        for(int i = 0; i < N; i++){
            if(str.charAt(i) == 'A') A++;
            else B++;
        }

        if(A > B) System.out.println('A');
        else if(A == B) System.out.println("Tie");
        else System.out.println('B');
    }

}