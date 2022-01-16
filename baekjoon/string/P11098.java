package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11098 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            int maxPay = 0;
            String maxPlayer = "";

            for(int n = 0; n < N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int pay = Integer.parseInt(st.nextToken());
                String player = st.nextToken();

                if(maxPay < pay) {
                    maxPay = pay;
                    maxPlayer = player;
                }
            }

            sb.append(maxPlayer + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}