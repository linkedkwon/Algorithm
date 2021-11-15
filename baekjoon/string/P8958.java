package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            int cnt = 0, seq = 0;
            for(int j = 0; j < str.length(); j++){
                seq = str.charAt(j) == 'O' ? seq + 1 : 0;
                cnt += seq;
            }
            System.out.println(cnt);
        }
        br.close();
    }
}