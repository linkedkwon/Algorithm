package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = new String[N];
        for(int i = 0; i < N; i++)
            str[i] = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str[0].length(); i++){
            int cnt = 1;
            char c = str[0].charAt(i);
            for(int j = 1; j < N; j++){
                if(c != str[j].charAt(i))
                    break;
                cnt++;
            }
            sb.append(cnt == N ? c : "?");
        }

        System.out.println(sb.toString());
        br.close();
    }
}