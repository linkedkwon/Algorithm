package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10811 {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];

        for(int i = 1; i <= n; i++)
            arr[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            int len = (y - x + 1) / 2;
            for(int j = 0; j < len; j++){
                int tmp = arr[x + j];
                arr[x + j] = arr[y - j];
                arr[y - j] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append(arr[i]).append(' ');

        System.out.println(sb);
        br.close();
    }

}