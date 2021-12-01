package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//greedy version
public class P2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), cnt = 0;

        while(N > 0){
            if(N % 5 == 0) {
                cnt += N / 5;
                break;
            }
            N -= 3;
            cnt++;
        }

        System.out.println(N < 0 ? -1 : cnt);
        br.close();
    }
}