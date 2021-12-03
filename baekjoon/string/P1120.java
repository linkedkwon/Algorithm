package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1120 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken(), B = st.nextToken();

        System.out.println(B.contains(A) ? "0" : compareStr(A, B));
    }

    private static int compareStr(String A, String B){

        int min = A.length(), dx = 0;
        while(A.length() + dx <= B.length()){
            int match = 0;
            for(int i = 0; i < A.length(); i++){
                if(A.charAt(i) != B.charAt(dx + i))
                    match++;
            }
            min = Math.min(min, match);
            dx++;
        }

        return min;
    }
}