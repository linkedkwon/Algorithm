package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3062 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringBuilder sbTmp = new StringBuilder(br.readLine());
            int a = Integer.parseInt(sbTmp.toString()),
                b = Integer.parseInt(sbTmp.reverse().toString());

            String str = Integer.toString(a + b);

            int len = str.length() / 2;
            boolean isEquals = true;
            for(int i = 0; i < len; i++){
                if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                    isEquals = false;
                    break;
                }
            }
            sb.append(isEquals ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
        br.close();
    }

}