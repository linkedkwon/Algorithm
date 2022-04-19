package baekjoon.knuth_morris_pratt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9253 {

    static String A, B, PATTERN;
    static int[] TABLE;

    public static void main(String[] args) throws IOException{
        readIn();
        setPITable();
        System.out.println(kmp(A) && kmp(B) ? "YES" : "NO");
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine(); B = br.readLine(); PATTERN = br.readLine();
        br.close();
    }

    static void setPITable(){
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

    static boolean kmp(String str){
        boolean isMatched = false;
        int dx = 0, len = str.length(), subLen = PATTERN.length();

        for(int i = 0; i < len; i++){
            while(dx > 0 && str.charAt(i) != PATTERN.charAt(dx)){
                dx = TABLE[dx - 1];
            }

            if(str.charAt(i) == PATTERN.charAt(dx)){
                if(dx == subLen - 1){
                    isMatched = true;
                    break;
                }else
                    dx++;
            }
        }
        return isMatched;
    }

}