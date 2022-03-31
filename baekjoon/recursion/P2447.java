package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2447 {

    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        appendStar(N, 0, 0);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(arr[i], ' ');
        br.close();
    }

    static void appendStar(int depth, int dx, int dy){
        if(depth == 1){
            arr[dx][dy] = '*';
            return;
        }

        int d = depth / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 1)
                    continue;
                else
                    appendStar(d, (i * d) + dx, (j * d) + dy);
            }
        }
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                sb.append(arr[i][j]);
            sb.append('\n');
        }

        System.out.println(sb);
    }

}