package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3059 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int[] arr = new int[26];

            String str = br.readLine();
            int len = str.length();
            for(int i = 0; i < len; i++){
                arr[str.charAt(i) - 65]++;
            }

            int sum = 0;
            for(int i = 0; i < 26; i++){
                if(arr[i] == 0)
                    sum += 65 + i;
            }
            sb.append(sum).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}