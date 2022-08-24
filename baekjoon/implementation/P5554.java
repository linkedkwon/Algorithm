package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5554 {

    static int secondSum;

    public static void main(String[] arsg) throws IOException{
        preProcess();
        process();
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 4; i++)
            secondSum += Integer.parseInt(br.readLine());

        br.close();
    }

    static void process(){
        int m = secondSum / 60,
            s = secondSum % 60;

        System.out.println(m + "\n" + s);
    }

}