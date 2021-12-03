package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9093 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                swapString(st.nextToken());
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void swapString(String token){
        char[] arr = token.toCharArray();
        int len = arr.length - 1;
        for(int i = 0; i < arr.length / 2; i++) {
            char c = arr[i];
            arr[i] = arr[len - i];
            arr[len - i] = c;
        }
        sb.append(String.valueOf(arr) + " ");
    }
}