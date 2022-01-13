package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr= new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 1; i < N + 1; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken());
            sb.append(arr[dy] - arr[dx - 1] + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}