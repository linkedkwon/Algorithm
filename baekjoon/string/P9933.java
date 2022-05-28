package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9933 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++)
            arr[i] = br.readLine();

        int dx = 0;
        for(int i = 0; i < N; i++){
            boolean hasFound = false;
            StringBuilder sb = new StringBuilder(arr[i]).reverse();
            for(int j = 0; j < N; j++){
                if(sb.toString().equals(arr[j])){
                    hasFound = true;
                    break;
                }
            }

            if(hasFound){
                dx = i;
                break;
            }
        }

        System.out.println(arr[dx].length() + " " + arr[dx].charAt(arr[dx].length() / 2));
        br.close();
    }

}