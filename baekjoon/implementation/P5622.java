package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = {2, 2, 2, 3, 3, 3,
                       4, 4, 4, 5, 5, 5,
                       6, 6, 6, 7, 7, 7,
                       7, 8, 8, 8, 9, 9, 9, 9};

        int cnt = str.length();
        for(int i = 0; i < str.length(); i++)
            cnt += alpha[str.charAt(i) - 65];

        System.out.println(cnt);
        br.close();
    }

}