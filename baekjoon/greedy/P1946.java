package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int cnt = 1, min = arr[1];
            for(int i = 2; i < N + 1; i++){
                if(arr[i] < min){
                    min = arr[i];
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}