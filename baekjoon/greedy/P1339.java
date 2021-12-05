package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++)
                arr[str.charAt(j) - 65] += Math.pow(10, str.length() - 1 - j);
        }

        Arrays.sort(arr);

        int answer = 0, q = 9;
        for(int i = 25; i > 16; i--)
            answer += arr[i] * q--;

        System.out.println(answer);
        br.close();
    }
}