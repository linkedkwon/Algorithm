package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2711 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int i = 0; i < str.length(); i++){
                if(i + 1 == dx)
                    continue;
                sb.append(str.charAt(i));
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}