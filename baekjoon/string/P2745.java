package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int i = N.length() - 1, q = 1, answer = 0;
        while(i >= 0){
            char c = N.charAt(i--);
            int n = c - 0 > 64 ? c - 55 : c - '0';
            answer += n * q;
            q *= B;
        }

        System.out.println(answer);
        br.close();
    }
}