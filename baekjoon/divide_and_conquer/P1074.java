package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {

    static int N, R, C;

    public static void main(String[] args) throws IOException{
        readIn();
        System.out.println(process(0, 0, N));
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = (int)Math.pow(2, Integer.parseInt(st.nextToken())); R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        br.close();
    }

    static int process(int x, int y, int n){
        if(n == 1)
            return 0;

        if (R < x + n / 2 && C < y + n / 2)
            return process(x, y, n / 2);
        else if (R < x + n / 2 && C < y + n)
            return process(x, y + n / 2, n / 2) + (int) Math.pow(n / 2, 2);
        else if (R < x + n && C < y + n / 2)
            return process(x + n / 2, y, n / 2) + (int) Math.pow(n / 2, 2) * 2;
        else
            return process(x + n / 2, y + n / 2, n / 2) + (int) Math.pow(n / 2, 2) * 3;
    }

}