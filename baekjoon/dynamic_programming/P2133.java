package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2133 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dx = new int[N + 2];
        dx[0] = 1;dx[2] = 3;

        for(int i = 4; i < dx.length; i+=2)
            dx[i] = dx[i - 2] * 3 + dx[i - 2] - dx[i - 4];

        System.out.println(dx[N]);
        br.close();
    }
}