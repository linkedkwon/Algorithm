package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while(!(str = br.readLine()).equals("0")){

            int left = 0, right = str.length() -1;
            while(left < right){
                if(str.charAt(left) != str.charAt(right))
                    break;
                left++;
                right--;
            }
            sb.append(left == str.length() / 2 ? "yes\n" : "no\n");
        }

        System.out.println(sb);
        br.close();
    }
}