package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int cnt = 0, dx = 1, sum = 1;

        while(cnt < x){
            cnt += dx++;
            sum++;
        }

        int dy = x - (cnt - dx + 1);
        System.out.println(sum % 2 == 0 ? (sum - dy) + "/" + dy : dy + "/" + (sum - dy));

        br.close();
    }

}