package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2720 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] change = {25, 10, 5, 1};

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            int c = Integer.parseInt(br.readLine());
            for(int i = 0; i < 4; i++){
                sb.append(c / change[i] + " ");
                c %= change[i];
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}