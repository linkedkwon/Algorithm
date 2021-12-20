package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P2935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger A = new BigInteger(br.readLine());
        char c = br.readLine().charAt(0);
        BigInteger B = new BigInteger(br.readLine());

        System.out.println(c == '*' ? A.multiply(B) : A.add(B));
        br.close();
    }
}