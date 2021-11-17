package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26];
        for(int i = 0; i < 26; i++)
            arr[i] = 101;

        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 97;
            arr[idx] = Math.min(i, arr[idx]);
        }

        for(int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i] == 101 ? -1 : arr[i]);
        br.close();
    }
}