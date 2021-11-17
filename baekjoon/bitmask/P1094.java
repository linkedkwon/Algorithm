package baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int len = 64, cnt = 0;

        while(X > 0){
            if(len > X) {
                len = len >> 1;
                continue;
            }
            X -= len;
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}