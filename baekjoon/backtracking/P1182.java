package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182 {

    static int N, S, CNT;
    static int[] seq;

    public static void main(String[] args) throws IOException{
        readIn();
        backtracking(0, 0);
        System.out.println(S == 0 ? CNT - 1 : CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void backtracking(int depth, int sum){
        if(sum == S)
            CNT++;
        for(int i = depth; i < N; i++)
            backtracking(i + 1, sum + seq[i]);
    }

}