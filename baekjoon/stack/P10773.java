package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K];

        int top = 0;
        for(int i = 0; i < K; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                top--;
            else
                arr[top++] = n;
        }

        int sum = 0;
        for(int i = 0; i < top; i++)
            sum += arr[i];

        System.out.println(sum);
        br.close();
    }
}