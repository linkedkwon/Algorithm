package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5026 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.charAt(0) == 'P') {
                sb.append("skipped").append('\n');
                continue;
            }

            String[] num = str.split( "\\+");
            sb.append(Integer.parseInt(num[0]) + Integer.parseInt(num[1])).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}