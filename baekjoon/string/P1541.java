package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int answer = 0;

        String[] sub1 = str[0].split("[+]");
        for(int i = 0; i < sub1.length; i++)
            answer += Integer.parseInt(sub1[i]);

        for(int i = 1; i < str.length; i++){
            String[] sub2 = str[i].split("[+]");
            int sum = 0;
            for(int j = 0; j < sub2.length; j++)
                sum += Integer.parseInt(sub2[j]);
            answer += sum * -1;
        }

        System.out.println(answer);
        br.close();
    }
}