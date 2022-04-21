package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4458 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            char[] arr = br.readLine().toCharArray();
            if(arr[0] > 96)
                arr[0] = (char)(arr[0] - 32);
            sb.append(new String(arr)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}