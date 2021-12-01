package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int zeroFlag = 0, sum = 0;
        for(int i = 0; i < N.length(); i++){
            if(N.charAt(i) == '0')
                zeroFlag = 1;
            sum += N.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        if(zeroFlag != 1 || sum % 3 != 0) {
            sb.append("-1");
        }
        else {
            char[] arr = N.toCharArray();
            Arrays.sort(arr);
            for(int i = arr.length - 1; i >= 0; i--)
                sb.append(arr[i]);
        }

        System.out.println(sb);
        br.close();
    }
}