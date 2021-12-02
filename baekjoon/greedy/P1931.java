package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) ->
                o1[1] == o2[1] ? (o1[0] - o2[0]) : (o1[1] - o2[1]));

        int cnt = 1;
        int t = arr[0][1];
        for(int i = 1; i < N; i++){
            if(t <= arr[i][0]){
                cnt++;
                t = arr[i][1];
            }
        }

        System.out.println(cnt);
        br.close();
    }
}