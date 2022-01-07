package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2754 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.length() < 2)
            System.out.println("0.0");
        else {
            double score = 0;

            switch (str.charAt(0)){
                case 'A': score += 4; break;
                case 'B': score += 3; break;
                case 'C': score += 2; break;
                case 'D': score += 1; break;
            }

            switch (str.charAt(1)){
                case '+': score += 0.3; break;
                case '0': break;
                case '-': score -= 0.3; break;
            }

            System.out.println(score);
        }
    }
}