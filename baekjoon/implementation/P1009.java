package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1009 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = {0, 1, 4, 4, 2, 1, 1, 4, 4, 2};
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) % 10, b = Integer.parseInt(st.nextToken());
            if(a == 0){
                sb.append("10").append('\n');
                continue;
            }

            if(arr[a] == 1){
                sb.append(a).append('\n');
                continue;
            }

            if(b <= arr[a]){
                sb.append((int)Math.pow(a, b) % 10).append('\n');
            }else{
                int r = b % arr[a] == 0 ? arr[a] : b % arr[a];
                sb.append((int)Math.pow(a, r) % 10).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }

}