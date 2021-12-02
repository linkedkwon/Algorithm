package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                if(c <= 'M') c += 13;
                else c -= 13;

            }
            else if(c >= 'a' && c <= 'z'){
                if(c <= 'm') c += 13;
                else c -= 13;
            }
            sb.append(c);
        }

        System.out.println(sb);
        br.close();
    }
}