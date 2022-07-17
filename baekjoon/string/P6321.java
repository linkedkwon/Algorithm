package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6321 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            sb.append("String #" + (i + 1)).append('\n');

            int len = str.length();
            for(int j = 0; j < len; j++){
                char c = str.charAt(j);
                sb.append(c == 'Z' ? 'A' : (char)(c + 1));
            }
            sb.append('\n').append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}