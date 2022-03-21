package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15829 {

    static int N;
    static String str;

    public static void main(String[] args) throws IOException{
        readIn();
        hash();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str =  br.readLine();
        br.close();
    }

    static void hash(){
        int m = 1234567891;
        long sum = 0, r = 1;
        for(int i = 0; i < N; i++){
            sum += (str.charAt(i) - 97 + 1) * r % m;
            r = (r * 31) % m;
        }
        System.out.println(sum % m);
    }

}