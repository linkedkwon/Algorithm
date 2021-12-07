package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[2];
        char tmp = s.charAt(0);
        arr[tmp - '0']++;
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(tmp != c) {
                arr[c - '0']++;
                tmp = c;
            }
        }
        System.out.println(Math.min(arr[0], arr[1]));
        br.close();
    }
}