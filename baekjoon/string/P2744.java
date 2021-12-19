package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2744 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            sb.append(c <= 90 ? (char)(c + 32) : (char)(c - 32));
        }

        System.out.println(sb);
        br.close();
    }
}