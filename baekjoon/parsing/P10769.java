package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10769 {

    static int happyCnt, sadCnt;
    static String str;

    public static void main(String[] args) throws IOException{
        readIn();
        parseStr();
        if(happyCnt == sadCnt) System.out.println(happyCnt == 0 ? "none" : "unsure");
        else System.out.println(happyCnt > sadCnt ? "happy" : "sad");
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        br.close();
    }

    static void parseStr(){
        int len = str.length(), face = 0;
        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            if(c == ':')
                face++;
            else if(c == '-' && face == 1)
                face++;
            else if(c == ')' && face == 2){
                happyCnt++;
                face = 0;
            }else if(c == '(' && face == 2){
                sadCnt++;
                face = 0;
            }else
                face = 0;
        }
    }

}