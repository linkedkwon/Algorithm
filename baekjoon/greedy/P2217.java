package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int max = arr[N - 1];
        for(int i = 0; i < N - 1; i++)
            max = Math.max(max, arr[i] * (N - i));

        System.out.println(max);
        br.close();
    }
}