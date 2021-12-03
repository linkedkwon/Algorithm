package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] v = new long[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++)
            v[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long min = Long.MAX_VALUE, cost = 0;
        for(int i = 0; i < N - 1; i++){
            min = Math.min(min, Integer.parseInt(st.nextToken()));
            cost += min * v[i];
        }

        System.out.println(cost);
        br.close();
    }
}