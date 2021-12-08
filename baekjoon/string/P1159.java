package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        for(int i = 0; i < N; i++)
            arr[br.readLine().charAt(0) - 97]++;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(arr[i] >= 5)
                sb.append((char)(i + 97));
        }

        System.out.println(sb.length() == 0 ? "PREDAJA":sb);
        br.close();
    }
}