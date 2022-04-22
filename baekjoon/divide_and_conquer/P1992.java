package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1992 {

    static int N;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        compressTree(0, 0, N);
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for(int i = 0; i < N; i++)
            arr[i] = br.readLine().toCharArray();
        br.close();
    }

    static void compressTree(int x, int y, int n){
        if(hasCompressed(x, y, n)){
            sb.append(arr[x][y]);
            return;
        }

        int half = n / 2;
        sb.append('(');
        compressTree(x, y, half);
        compressTree(x, y + half, half);
        compressTree(x + half, y, half);
        compressTree(x + half, y + half, half);
        sb.append(')');
    }

    static boolean hasCompressed(int x, int y, int n){
        char color = arr[x][y];

        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(color != arr[i][j])
                    return false;
            }
        }
        return true;
    }

}