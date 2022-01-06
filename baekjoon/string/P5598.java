package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5598 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            int c = str.charAt(i);
            sb.append(c < 68 ? (char)(90 - (67 - c)) : (char)(c - 3));
        }

        System.out.println(sb);
        br.close();
    }

}