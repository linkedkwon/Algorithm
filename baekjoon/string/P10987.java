package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10987 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            switch(c){
                case 'a':cnt++; break;
                case 'e':cnt++; break;
                case 'i':cnt++; break;
                case 'o':cnt++; break;
                case 'u':cnt++; break;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}