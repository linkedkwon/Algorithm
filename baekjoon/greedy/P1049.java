package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1049 {

    static int N, M, MIN = 1000, COST;
    static int[] pack, piece;

    public static void main(String[] args) throws IOException{
        readIn();
        greedy();
        System.out.println(COST);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        pack = new int[M]; piece = new int[M];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            piece[i] = Integer.parseInt(st.nextToken());
            MIN = Math.min(MIN, piece[i]);
        }
        br.close();
    }

    static void greedy(){
        int packCost = MIN * 6;
        for(int i = 0; i < M; i++)
            packCost = Math.min(packCost, pack[i]);

        if(packCost == MIN * 6)
            COST = N * MIN;
        else
            COST = Math.min(((N / 6) * packCost) + ((N % 6) * MIN), ((N / 6) + 1) * packCost);
    }

}