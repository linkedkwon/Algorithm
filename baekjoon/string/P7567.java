package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P7567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = 10;
        char tmp = str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            char c = str.charAt(i);
            len += tmp == c ? 5 : 10;
            tmp = c;
        }

        System.out.println(len);
        br.close();
    }
}
