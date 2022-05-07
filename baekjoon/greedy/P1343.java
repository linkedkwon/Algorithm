package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1343 {

    static boolean hasFilled = true;
    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(hasFilled ? sb : "-1");
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        br.close();
    }

    static void process(){
        int len = str.length(), stack = 0;
        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            if(c == '.'){
                if(stack % 2 != 0){
                    hasFilled = false;
                    break;
                }
                appendString(stack);
                sb.append('.');
                stack = 0;
            }else
                stack++;
        }

        if(stack % 2 == 0) appendString(stack);
        else hasFilled = false;
    }

    static void appendString(int stack){
        int q = stack / 4, r = (stack % 4) / 2;
        for(int j = 0; j < q; j++)
            sb.append("AAAA");

        for(int j = 0; j < r; j++)
            sb.append("BB");
    }

}