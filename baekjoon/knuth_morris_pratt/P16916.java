package baekjoon.knuth_morris_pratt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16916 {

    static String STR, SUB;
    static int[] TABLE;

    public static void main(String[] args) throws IOException{
        readIn();
        preProcess();
        kmp();
        System.out.println("0");
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        STR = br.readLine(); SUB = br.readLine();
        br.close();
    }

    static void preProcess(){
        int dx = 0, len = SUB.length();
        TABLE = new int[len];

        for(int i = 1; i < len; i++){
            while(dx > 0 && SUB.charAt(i) != SUB.charAt(dx)){
                dx = TABLE[dx - 1];
            }
            if(SUB.charAt(i) == SUB.charAt(dx))
                TABLE[i] = ++dx;
        }
    }

    static void kmp(){
        int dx = 0, len = STR.length(), subLen = SUB.length();

        for(int i = 0; i < len; i++){
            while(dx > 0 && STR.charAt(i) != SUB.charAt(dx)){
                dx = TABLE[dx - 1];
            }

            if(STR.charAt(i) == SUB.charAt(dx)){
                if(dx == subLen - 1){
                    System.out.println("1");
                    System.exit(0);
                }else
                    dx++;
            }
        }
    }

}