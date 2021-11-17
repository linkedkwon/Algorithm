package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); int[] arr = new int[26];

        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 65;
            arr[idx >= 32 ? idx - 32 : idx]++;
        }

        int max = 0, cnt = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[max])
                cnt++;
            if(arr[i] > arr[max]) {
                max = i; cnt = 0;
            }
        }

        System.out.println(cnt > 0 ? '?' : (char)(max + 65));
        br.close();
    }
}