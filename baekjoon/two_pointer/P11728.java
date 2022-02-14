package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11728 {

    static int N, M;
    static int[] A, B;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        mergeArrays();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        A = new int[N]; B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(int o : list)
            sb.append(o).append(' ');
        System.out.println(sb);
    }

    static void mergeArrays(){
        int dx = 0, dy = 0;
        while(dx < N && dy < M){
            if(A[dx] < B[dy])
                list.add(A[dx++]);
            else if(A[dx] == B[dy]){
                list.add(A[dx++]);
                list.add(B[dy++]);
            }else
                list.add(B[dy++]);

        }

        if(dx < N){
            for(int i = dx; i < N; i++)
                list.add(A[i]);
        }

        if(dy < M){
            for(int i = dy; i < M; i++)
                list.add(B[i]);
        }
    }

}