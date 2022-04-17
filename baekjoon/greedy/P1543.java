package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1543 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(), word = br.readLine();

        int len = str.length(), subLen = word.length(), cnt = 0;
        for(int i = 0; i < len; i++){
            if(str.charAt(i) == word.charAt(0)){
                int stack = 1, dx = i + 1;
                for(int j = 1; j < subLen; j++){
                    if(dx >= len || str.charAt(dx) != word.charAt(j))
                        break;
                    stack++;
                    dx++;
                }

                if(stack == subLen){
                    i = dx - 1;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

}