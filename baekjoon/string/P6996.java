package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6996 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken(), B = st.nextToken();
            int[] ascA = new int[26], ascB = new int[26];

            int lenA = A.length(), lenB = B.length();
            if(lenA != lenB) {
                sb.append(A + " & " + B).append(" are NOT anagrams.").append('\n');
                continue;
            }

            for(int j = 0; j < lenA; j++){
                ascA[A.charAt(j) - 97]++;
                ascB[B.charAt(j) - 97]++;
            }

            boolean isEqual = true;
            for(int j = 0; j < 26; j++){
                if(ascA[j] != ascB[j]){
                    isEqual = false;
                    break;
                }
            }

            sb.append(A + " & " + B).append(isEqual ?
                    " are anagrams." : " are NOT anagrams.").append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}