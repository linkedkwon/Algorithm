package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2303 {

    static int N, DX, MAX, SUM, ANSWER;
    static int[][] card;

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < N; i++){
            SUM = 0; DX = i;
            dfs(0, 0, 0);
            if(MAX < SUM){
                MAX = SUM;
                ANSWER = i + 1;
            }else if(MAX == SUM){
                ANSWER = i + 1;
            }
        }
        System.out.println(ANSWER);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N][5];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++)
                card[i][j] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static void dfs(int dy, int depth, int sum){
        if(depth == 3){
            SUM = Math.max(SUM, sum % 10);
            return;
        }

        for(int i = dy; i < 5; i++)
            dfs(i + 1, depth + 1, sum + card[DX][i]);
    }

}