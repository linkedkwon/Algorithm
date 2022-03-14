package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1371 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        int max = 0;

        String str = "";
        while((str = br.readLine()) != null){
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == ' ')
                    continue;
                arr[c - 97]++;
                max = Math.max(max, arr[c - 97]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(arr[i] == max)
                sb.append((char)(i + 97));
        }

        System.out.println(sb);
        br.close();
    }

}