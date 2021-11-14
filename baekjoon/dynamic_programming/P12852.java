package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dx = new int[N + 5], dy = new int[N + 5];
        dx[2] = 1; dx[3] = 1; dy[2] = 1; dy[3] = 1;

        for(int i = 4; i < N + 1; i++){
            dx[i] = dx[i - 1] + 1;
            dy[i] = i - 1;
            if(i % 3 == 0 && dx[i / 3] < dx[i]){
                dx[i] = dx[i / 3] + 1;
                dy[i] = i / 3;
            }
            if(i % 2 == 0 && dx[i / 2] < dx[i]){
                dx[i] = dx[i / 2] + 1;
                dy[i] = i / 2;
            }
        }

        System.out.println(dx[N]);
        int idx = dy[N];
        System.out.print(N+" ");
        for(int i = 0; i < dx[N] ; i++){
            System.out.print(idx + " ");
            idx = dy[idx];
        }
        br.close();
    }
}