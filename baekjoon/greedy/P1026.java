package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class P1026 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N], B = new Integer[N];

        inputStream(A);
        inputStream(B);

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int sum = 0;
        for(int i = 0; i < N; i++)
            sum += A[i] * B[i];

        System.out.println(sum);
        br.close();
    }

    public static void inputStream(Integer[] arr) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }
}