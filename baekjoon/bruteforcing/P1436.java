package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dx = 666;

        while(true){
            int dy = dx, cnt = 0;
            while(dy > 0){
                cnt = dy % 10 == 6 ? cnt + 1 : 0;
                if(cnt == 3)
                    break;
                dy /= 10;
            }

            if(cnt == 3)
                N--;
            if(N == 0)
                break;

            dx++;
        }

        System.out.println(dx);
        br.close();
    }

}