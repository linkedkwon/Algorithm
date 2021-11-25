package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0, a = 0, b = 2, c = 4, d = 6;
        for(int i = 1; i < 9; i++){
            String str = br.readLine();
            if(str.charAt(a) == 'F')
                cnt++;
            if(str.charAt(b) == 'F')
                cnt++;
            if(str.charAt(c) == 'F')
                cnt++;
            if(str.charAt(d) == 'F')
                cnt++;

            int dx = i % 2 == 0 ? -1 : 1;
            a += dx; b += dx; c += dx; d += dx;
        }
        System.out.println(cnt);
        br.close();
    }
}