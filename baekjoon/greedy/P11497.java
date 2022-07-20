package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11497 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++)
                arr[n] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int[] lined = new int[N];
            int dx = 0, dy = N - 1;
            for(int i = 0; i < N; i++){
                if(i % 2 == 0)
                    lined[dx++] = arr[i];
                else
                    lined[dy--] = arr[i];
            }

            int max = Math.abs(lined[N - 1] - lined[0]);
            for(int i = 0; i < N - 1; i++)
                max = Math.max(max, Math.abs(lined[i] - lined[i + 1]));

            sb.append(max).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}