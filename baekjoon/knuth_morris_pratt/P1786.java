package baekjoon.knuth_morris_pratt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1786 {

    static int CNT;
    static int[] TABLE;
    static String STR, PATTERN;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        preProcess();
        kmp();
        System.out.println(CNT + "\n" + sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        STR = br.readLine(); PATTERN = br.readLine();
        br.close();
    }

    static void preProcess(){
        int dx = 0, len = PATTERN.length();
        TABLE = new int[len];

        for(int i = 1; i < len; i++){
            while(dx > 0 && PATTERN.charAt(i) != PATTERN.charAt(dx)){
                dx = TABLE[dx - 1];
            }

            if(PATTERN.charAt(i) == PATTERN.charAt(dx))
                TABLE[i] = ++dx;
        }
    }

    static void kmp(){
        int dx = 0, len = STR.length(), subLen = PATTERN.length();
        for(int i = 0; i < len; i++){
            while(dx > 0 && STR.charAt(i) != PATTERN.charAt(dx)){
                dx = TABLE[dx - 1];
            }

            if(STR.charAt(i) == PATTERN.charAt(dx)){
                if(dx == subLen - 1) {
                    CNT++;
                    sb.append(i - subLen + 2).append(' ');
                    dx = TABLE[dx];
                }else
                    dx++;
            }
        }
    }

}