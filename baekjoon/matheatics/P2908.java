package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2908 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = reverseNum(Integer.parseInt(st.nextToken()));
        int B = reverseNum(Integer.parseInt(st.nextToken()));

        System.out.println(A > B ? A : B);
        br.close();
    }

    public static int reverseNum(int num){
        int reversed = 0;
        while(num != 0){
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        return reversed;
    }

}