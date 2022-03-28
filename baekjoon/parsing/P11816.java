package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11816 {

    static String str;

    public static void main(String[] args) throws IOException{
        readIn();
        parseStr();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        br.close();
    }

    static void parseStr(){
        char c = str.charAt(0);
        System.out.println(c == '0' ? str.charAt(1) == 'x' ? getHexadecimal() : getBinaryNumber() : str);
    }

    static int getBinaryNumber(){
        int dx = 0, num = 0, len = str.length();
        for(int i = len - 1; i >= 1; i--)
            num += (str.charAt(i) - '0') * Math.pow(8, dx++);

        return num;
    }

    static int getHexadecimal(){
        int dx = 0, num = 0, len = str.length();
        for(int i = len - 1; i >= 2; i--){
            char c = str.charAt(i);
            if(c > 96) num += (c - 87) * Math.pow(16, dx++);
            else num += (c - '0') * Math.pow(16, dx++);
        }

        return num;
    }

}