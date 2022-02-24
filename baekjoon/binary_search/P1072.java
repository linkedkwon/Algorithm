package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1072 {

    static long X, Y, MIN = Integer.MAX_VALUE;
    static long rate;

    public static void main(String[] args) throws IOException{
        readIn();
        bs();
        System.out.println(MIN == Integer.MAX_VALUE ? "-1" : MIN - Y);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken()); Y = Long.parseLong(st.nextToken());
        rate = Y * 100 / X;
        br.close();
    }

    static void bs(){
        long left = Y + 1, right = Integer.MAX_VALUE, mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            long tmp = mid * 100 / (X + mid - Y);
            if(tmp == rate){
                left = mid + 1;
            }else{
                MIN = Math.min(MIN, mid);
                right = mid - 1;
            }
        }
    }

}