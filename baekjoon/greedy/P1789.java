package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong((br.readLine()));

        long i = 1;
        while(true){
            N -= i;
            if(N <= i)
                break;
            i++;
        }

        System.out.println(i);
        br.close();
    }
}