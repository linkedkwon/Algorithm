package baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11723 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()), mask = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String inst = st.nextToken();
            int num = 0;
            switch (inst){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    mask |= (1 << (num - 1));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    mask &= ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((mask & (1 << (num - 1))) != 0 ? '1' : '0').append('\n');
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    mask ^= (1 << (num - 1));
                    break;
                case "all":
                    mask |= (~0);
                    break;
                case "empty":
                    mask &= 0;
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }

}