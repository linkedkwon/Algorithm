package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6603 {

    static int K;
    static int[] S;
    static boolean[] used;
    static String str = "";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        while(!(str = br.readLine()).equals("0")){
            readIn();
            selectNumber(0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    static void readIn(){
        StringTokenizer st = new StringTokenizer(str);
        K = Integer.parseInt(st.nextToken());
        S = new int[K];
        used = new boolean[K];

        for(int i = 0; i < K; i++)
            S[i] = Integer.parseInt(st.nextToken());
    }

    static void selectNumber(int dx, int depth){
        if(depth == 6){
            for(int i = 0; i < K; i++) {
                if(used[i])
                    sb.append(S[i]).append(' ');
            }
            sb.append('\n');
        }

        for(int i = dx; i < K; i++){
            used[i] = true;
            selectNumber(i + 1, depth + 1);
            used[i] = false;
        }
    }

}