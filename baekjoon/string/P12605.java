package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//stack < loop
public class P12605 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append("Case #" + (i + 1) + ": ");

            String[] str = br.readLine().split(" ");
            for(int j = str.length - 1; j >= 0; j--)
                sb.append(str[j] + " ");

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}