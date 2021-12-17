package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11365 {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String str = "";
        while(!(str = br.readLine()).equals("END")){
            appendStr(str.toCharArray());
        }

        System.out.println(sb);
        br.close();
    }

    public static void appendStr(char[] arr){
        int len = arr.length - 1;
        for(int i = 0; i < arr.length / 2; i++){
            char tmp = arr[i];
            arr[i] = arr[len - i];
            arr[len - i] = tmp;
        }

        sb.append(String.valueOf(arr) + "\n");
    }
}