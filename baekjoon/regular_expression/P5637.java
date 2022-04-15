package baekjoon.regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5637 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String paragraph = "";
        while(true){
            String str = br.readLine();
            if(str.contains("E-N-D")){
                paragraph += str.replace("E-N-D", "");
                break;
            }
            paragraph += str;
        }

        String[] word = paragraph.toLowerCase().trim().split("[^a-z-]");
        int size = word.length, max = 0, dx = 0;
        for(int i = 0; i < size; i++){
            int len = word[i].length();
            if(len > max){
                max = len;
                dx = i;
            }
        }

        System.out.println(word[dx]);
        br.close();
    }

}