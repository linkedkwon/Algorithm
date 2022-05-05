package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1213 {

    static char axis;
    static boolean hasAnswer;
    static String str;
    static int[] arr = new int[26];
    static StringBuilder prefix;

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
        if(hasAnswer){
            System.out.println(str.length() % 2 == 0
                    ? prefix.toString() + prefix.reverse()
                    : prefix.toString() + axis + prefix.reverse());
        }else
            System.out.println("I'm Sorry Hansoo");
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int len = str.length();
        for(int i = 0; i < len; i++)
            arr[str.charAt(i) - 65]++;

        hasAnswer = true;
        prefix = new StringBuilder();
        br.close();
    }

    static void process(){
        boolean hasAxis = false;
        for(int i = 0; i < 26; i++){
            if(arr[i] == 0)
                continue;
            char c = (char)(65 + i);
            if(arr[i] % 2 == 1){
                if(hasAxis){
                    hasAnswer = false;
                    return;
                }
                axis = c;
                hasAxis = true;
            }
            writePalindrome(arr[i] / 2, (c));
        }
    }

    static void writePalindrome(int len, char c){
        for(int i = 0; i < len; i++)
            prefix.append(c);
    }

}