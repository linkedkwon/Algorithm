package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9324 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int[] arr = new int[26];

            String read = br.readLine();
            int len = read.length();
            boolean hasEncoded = true;
            for(int i = 0; i < len; i++){
                char c = read.charAt(i);
                arr[c - 65]++;

                if(arr[c - 65] == 3){
                    if(i + 1 == len){
                        hasEncoded = false;
                        break;
                    }else{
                        if(read.charAt(i + 1) != c){
                            hasEncoded = false;
                            break;
                        }
                        arr[c - 65] = 0;
                        i++;
                    }
                }
            }

            sb.append(hasEncoded ? "OK" : "FAKE").append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}