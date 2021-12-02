package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10162 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = {300, 60, 10};
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; i++){
            int cnt = 0, q = N / arr[i];
            if(q != 0){
                N = N % arr[i];
                cnt = q;
            }
            sb.append(cnt + " ");
        }

        System.out.println(N == 0 ? sb : "-1");
        br.close();
    }
}