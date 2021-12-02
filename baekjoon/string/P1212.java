package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String[] arr2 = {"0", "1", "10", "11", "100", "101", "110", "111"};
        String N = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(arr2[N.charAt(0) - '0']);
        for(int i = 1; i < N.length(); i++)
            sb.append(arr1[N.charAt(i) - '0']);

        System.out.println(sb);
        br.close();
    }
}