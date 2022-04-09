package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11945 {

    static int N, M;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        reverseStr();
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i = 0 ; i < N; i++)
            arr[i] = br.readLine().toCharArray();
        br.close();
    }

    static void reverseStr(){
        for(int i = 0; i < N; i++){
            for(int j = M - 1; j >= 0; j--)
                sb.append(arr[i][j]);
            sb.append('\n');
        }
    }

}