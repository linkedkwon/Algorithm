package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1780 {

    static int N, DX, DY, DZ;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        process(0, 0, N);
        System.out.println(DX + "\n" + DY + "\n" + DZ);
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
        if(countNumber(x, y, n)){
            if(arr[x][y] == -1) DX++;
            else if(arr[x][y] == 0) DY++;
            else DZ++;
            return;
        }

        int divided = n / 3;
        process(x, y, divided);
        process(x, y + divided, divided);
        process(x, y + 2 * divided, divided);

        process(x + divided, y, divided);
        process(x + divided, y + divided, divided);
        process(x + divided, y + 2 * divided, divided);

        process(x + 2 * divided, y, divided);
        process(x + 2 * divided, y + divided, divided);
        process(x + 2 * divided, y + 2 * divided, divided);
    }

    static boolean countNumber(int x, int y, int n){
        int num = arr[x][y];
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(num != arr[i][j])
                    return false;
            }
        }
        return true;
    }

}