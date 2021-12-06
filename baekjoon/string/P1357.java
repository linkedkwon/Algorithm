package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1357 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(rev(Integer.toString(rev(st.nextToken()) + rev(st.nextToken()))));
        br.close();
    }

    public static int rev(String s){
        int n = 0;
        for(int i = 0; i < s.length(); i++){
            n += (s.charAt(i) - '0') * Math.pow(10, i);
        }
        return n;
    }
}