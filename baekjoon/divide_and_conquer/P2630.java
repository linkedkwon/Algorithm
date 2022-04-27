package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {

    static int N, DX, DY;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        process(0, 0, N);
        System.out.println(DX + "\n" + DY);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static void process(int x, int y, int n){
        if(n == 1 || hasSameColor(x, y, n)){
            if(arr[x][y] == 0) DX++;
            else DY++;
            return;
        }

        int divided = n / 2;
        process(x, y, divided);
        process(x, y + divided, divided);
        process(x + divided, y, divided);
        process(x + divided, y + divided, divided);
    }

    static boolean hasSameColor(int x, int y, int n){
        int color = arr[x][y];
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(color != arr[i][j])
                    return false;
            }
        }
        return true;
    }

}