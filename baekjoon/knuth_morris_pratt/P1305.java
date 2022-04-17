package baekjoon.knuth_morris_pratt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1305 {

    static int LEN;
    static String STR;

    public static void main(String[] args) throws IOException{
        readIn();
        System.out.println(LEN - getMaxFixLen());
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LEN = Integer.parseInt(br.readLine());
        STR = br.readLine();
        br.close();
    }

    static int getMaxFixLen(){
        int[] table = new int[LEN];
        int dx = 0;
        for(int i = 1; i < LEN; i++){
            while(dx > 0 && STR.charAt(i) != STR.charAt(dx)){
                dx = table[dx - 1];
            }

            if(STR.charAt(i) == STR.charAt(dx))
                table[i] = ++dx;
        }

        return table[LEN - 1];
    }

}