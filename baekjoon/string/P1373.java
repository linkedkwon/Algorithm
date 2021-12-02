package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1373 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int[] arr = {1, 2, 4};

        int dx = 0, n = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            n += (str.charAt(i) - '0') * arr[dx++];
            if(dx == 3){
                sb.append(n);
                dx = 0; n = 0;
            }
        }

        if(dx != 0) sb.append(n);

        System.out.println(sb.reverse());
        br.close();
    }
}