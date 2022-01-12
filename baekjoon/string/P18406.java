package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P18406 {

    private static char[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        int len = arr.length / 2;

        System.out.println(sum(0, len) == sum(len, arr.length) ? "LUCKY" : "READY");
        br.close();
    }

    public static int sum(int dx, int len){
        int sum = 0;
        for(int i = dx; i < len; i++)
            sum += arr[i];

        return sum;
    }
}