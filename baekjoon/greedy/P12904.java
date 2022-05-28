package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12904 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder tb = new StringBuilder(br.readLine());

        while(tb.length() > sb.length()){
            boolean endsWithB = tb.charAt(tb.length() - 1) == 'B' ? true : false;
            tb.delete(tb.length() - 1, tb.length());
            if(endsWithB)
                tb.reverse();
        }

        System.out.println(sb.toString().equals(tb.toString()) ? "1" : "0");
        br.close();
    }

}