package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2446 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        printTree(1, 0, N * 2 - 1);
        N--;
        printTree(2, N - 1, 3);
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    static void printTree(int type, int dx, int dy){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < dx; j++)
                sb.append(' ');

            for(int j = 0; j < dy; j++)
                sb.append('*');

            if(type == 1) { dx++; dy -= 2;
            }else{ dx--; dy += 2;}

            sb.append('\n');
        }
    }

}