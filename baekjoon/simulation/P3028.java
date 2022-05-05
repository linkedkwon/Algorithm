package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3028 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();

        int dx = 1, len = order.length();
        for(int i = 0; i < len; i++){
            char c = order.charAt(i);
            if(c == 'A'){
                if(dx == 1) dx = 2;
                else if(dx == 2) dx = 1;
            }else if(c == 'B'){
                if(dx == 2) dx = 3;
                else if(dx == 3) dx = 2;
            }else{
                if(dx == 1) dx = 3;
                else if(dx == 3) dx = 1;
            }
        }

        System.out.println(dx);
        br.close();
    }

}