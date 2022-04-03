package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1475 {

    static int cnt;
    static String str;
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException{
        readIn();
        parseStr();
        getNecessaryCnt();
        System.out.println(cnt);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        br.close();
    }

    static void parseStr(){
        int len = str.length();
        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            arr[c - '0']++;
        }
    }

    static void getNecessaryCnt(){
        int common = arr[6] + arr[9];
        cnt = common % 2 == 0 ? common / 2 : common / 2 + 1;

        for(int i = 0; i < 9; i++){
            if(i == 6) continue;
            cnt = Math.max(arr[i], cnt);
        }
    }

}