package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2857 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean hasFBI = false;
        for(int i = 1; i < 6; i++){
            String read = br.readLine();
            if(read.contains("FBI")) {
                hasFBI = true;
                sb.append(i).append(' ');
            }
        }

        System.out.println(hasFBI ? sb : "HE GOT AWAY!");
        br.close();
    }

}