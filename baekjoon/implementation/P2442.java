package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2442 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int h = Integer.parseInt(br.readLine());

        int dx = h - 1, dy = 1;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < dx; j++)
                sb.append(' ');

            for(int j = 0; j < dy; j++)
                sb.append('*');

            dx--; dy += 2;
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}