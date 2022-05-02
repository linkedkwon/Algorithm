package baekjoon.exponentiation_by_squaring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {

    static long C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken()); C = Long.parseLong(st.nextToken());
        System.out.println(divideAndConquer(B, A));
        br.close();
    }

    static long divideAndConquer(long n, long num){
        if(n == 1)
            return num % C;

        long tmp = divideAndConquer(n / 2, num);

        if(n % 2 == 1)
            return (tmp * tmp %  C) * num % C;

        return tmp * tmp % C;
    }

}