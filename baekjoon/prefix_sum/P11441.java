package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11441 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) + 1, sum = 0;
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 1; n < N; n ++){
            sum += Integer.parseInt(st.nextToken());
            arr[n] = sum;
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()),
                j = Integer.parseInt(st.nextToken());

            sb.append(arr[j] - arr[i - 1] + "\n");
        }

        System.out.println(sb);
        br.close();
    }

}