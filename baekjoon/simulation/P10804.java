package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10804 {

    public static void main(String[] args) throws IOException{
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                    12, 13, 14, 15, 16, 17, 18, 19, 20};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1,
                    len = (b - a) / 2;
            for(int j = 0; j <= len; j++){
                int tmp = arr[a + j];
                arr[a + j] = arr[b - j];
                arr[b - j] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 20; i++)
            sb.append(arr[i]).append(' ');

        System.out.println(sb);
        br.close();
    }

}