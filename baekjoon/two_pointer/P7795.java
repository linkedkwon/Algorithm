package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7795 {

    static int N, M, CNT;
    static int[] A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            readIn();
            Arrays.sort(A);
            Arrays.sort(B);
            tp();
        }
        System.out.println(sb);
        br.close();
    }

    static void readIn() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        A = new int[N]; B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        CNT = 0;
    }

    static void tp(){
        int dx = 0, dy = 0;
        while(dx < N && dy < M){
            if(A[dx] <= B[dy]){
                dx++;
            }else{
                CNT += N - dx;
                dy++;
            }
        }
        sb.append(CNT).append('\n');
    }

}