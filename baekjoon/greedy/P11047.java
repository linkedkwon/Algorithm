package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int cnt = 0, i = N;
        while(K != 0){
            if(K / arr[--i] == 0)
                continue;
            cnt += K / arr[i];
            K = K % arr[i];
        }

        System.out.println(cnt);
        br.close();
    }
}