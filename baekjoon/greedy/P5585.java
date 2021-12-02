package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int[] coin = {500, 100, 50, 10, 5, 1};

        int i = 0, cnt = 0;
        while(N > 0){
            int q = N / coin[i];
            if(q != 0) {
                cnt += q;
                N %= coin[i];
            }
            i++;
        }

        System.out.println(cnt);
        br.close();
    }
}