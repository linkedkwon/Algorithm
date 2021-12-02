package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while((str = br.readLine()) != null) {
            int[] arr = new int[4];
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c >= 96 && c <= 122)
                    arr[0]++;
                else if(c >= 65 && c <= 90)
                    arr[1]++;
                else if(c == ' ')
                    arr[3]++;
                else
                    arr[2]++;
            }
            sb.append(arr[0] +" " + arr[1] + " " + arr[2] + " " + arr[3] + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}