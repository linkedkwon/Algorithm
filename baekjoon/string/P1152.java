package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        int len = str.length() > 0 ? str.split(" ").length : 0;

        System.out.println(len);
        br.close();
    }
}