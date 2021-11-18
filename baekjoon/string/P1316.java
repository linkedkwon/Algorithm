package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), cnt = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int[] arr = new int[26];
            char c = str.charAt(0);
            int len = 1;
            for(int j = 1; j < str.length(); j++){
                char idx = str.charAt(j);
                if(arr[idx - 97] == -1)
                    break;
                if(c != idx) {
                    arr[c - 97] = -1;
                    c = idx;
                }
                len++;
            }
            if(len == str.length())
                cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}