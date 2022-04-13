package baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12833 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        System.out.println(C % 2 == 0 ? A : A ^ B);
        br.close();
    }

}