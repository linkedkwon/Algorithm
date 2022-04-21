package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1919 {

    static String A, B;
    static int[] arrA = new int[26], arrB = new int[26];

    public static void main(String[] args) throws IOException{
        readIn();
        setAlphaCount();
        System.out.println(getAlphaCount());
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine(); B = br.readLine();
        br.close();
    }

    static void setAlphaCount(){

        int len = A.length();
        for(int i = 0; i < len; i++)
            arrA[A.charAt(i) - 97]++;

        len = B.length();
        for(int i = 0; i < len; i++)
            arrB[B.charAt(i) - 97]++;
    }

    static int getAlphaCount(){
        int sum = 0;
        for(int i = 0; i < 26; i++)
            sum += Math.abs(arrA[i] - arrB[i]);

        return sum;
    }

}