package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append(arr[i]).append(' ');

        System.out.println(sb);
        br.close();
    }

}