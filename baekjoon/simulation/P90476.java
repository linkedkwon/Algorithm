package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P90476 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String str = br.readLine();
            int i = 0, n = Integer.parseInt(str);
            while(n != 6174){
                int[] num = new int[10];
                int len = str.length();
                num[0] += 4 - len;
                for(int j = 0; j < len; j++)
                    num[str.charAt(j) - '0']++;

                int max = 0, min = 0, dx = 1;
                for(int j = 9; j >= 0; j--){
                    for(int k = 0; k < num[j]; k++){
                        max = j == 0 ? max * 10 : max * 10 + j;
                        if(j == 0)
                            continue;
                        min += j * dx;
                        dx *= 10;
                    }
                }

                n = max - min;
                str = Integer.toString(n);
                i++;
            }
            sb.append(i).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}