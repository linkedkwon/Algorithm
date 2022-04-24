package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5218 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken(), B = st.nextToken();
            int len = A.length();

            sb.append("Distances: ");
            for(int i = 0; i < len; i++){
                char c1 = A.charAt(i), c2 = B.charAt(i);
                sb.append(c1 <= c2 ? c2 - c1 : c2 + 26 - c1).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}