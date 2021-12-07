package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int min = replaceNum(str[0], "6", "5") + replaceNum(str[1], "6", "5");
        int max = replaceNum(str[0], "5", "6") + replaceNum(str[1], "5", "6");

        System.out.println(min + " " + max);
        br.close();
    }

    public static int replaceNum(String str, String reg, String re){
        return Integer.parseInt(str.replaceAll(reg, re));
    }
}