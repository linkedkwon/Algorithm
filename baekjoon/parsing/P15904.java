package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15904 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ucpc = {'U', 'C', 'P', 'C'};

        int len = str.length(), dx = 0;
        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            if(c == ucpc[dx]) {
                dx++;
                if(dx == 4) break;
            }
        }

        System.out.println(dx == 4 ? "I love UCPC" : "I hate UCPC");
        br.close();
    }

}