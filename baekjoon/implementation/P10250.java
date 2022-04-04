package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10250 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken()), order = Integer.parseInt(st.nextToken());
            if(order <= h) {
                sb.append(order).append("01").append('\n');
            }else{
                int r = order % h, q = order/ h;
                if(r == 0){
                    sb.append(h);
                }else{
                    sb.append(r);
                    q++;
                }
                sb.append(q < 10 ? '0' : "").append(q).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }

}