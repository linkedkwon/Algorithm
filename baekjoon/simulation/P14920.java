package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14920 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), cnt = 0;

        while(n != 1){
            if(n % 2 == 0) n /= 2;
            else{
                n *= 3;
                n += 1;
            }
            cnt++;
        }

        System.out.println(cnt + 1);
        br.close();
    }

}