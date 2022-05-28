package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12904 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine(), t = br.readLine();

        while(s.length() < t.length()){
            if(t.endsWith("A"))
                t = t.substring(0, t.length() - 1);
            else if(t.endsWith("B")){
                t = t.substring(0, t.length() - 1);
                t = sb.append(t).reverse().toString();
            }
        }

        System.out.println(s.equals(t) ? "1" : "0");
        br.close();
    }
}
