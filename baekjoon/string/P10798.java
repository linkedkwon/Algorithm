package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[5];

        int maxLen = 0;
        for(int i = 0; i < 5; i++){
            str[i] = br.readLine();
            maxLen = Math.max(maxLen, str[i].length());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < maxLen; i++){
            for(int j = 0; j < 5; j++){
                if(i + 1 <= str[j].length())
                    sb.append(str[j].charAt(i));
            }
        }

        System.out.println(sb);
        br.close();
    }
}