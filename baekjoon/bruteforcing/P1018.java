package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for(int i = 0; i < N; i++)
            board[i] = br.readLine().toCharArray();

        char[][] wFrame = new char[8][8], bFrame = new char[8][8];
        String str1 = "WBWBWBWB", str2 = "BWBWBWBW";
        for(int i = 0; i < 8; i++){
            if(i % 2 == 0){
                wFrame[i] = str1.toCharArray();
                bFrame[i] = str2.toCharArray();
            }
            else{
                wFrame[i] = str2.toCharArray();
                bFrame[i] = str1.toCharArray();
            }
        }

        int min = 64;
        for(int i = 0; i < N - 7; i++){
            for(int j = 0; j < M - 7; j++){
                int wCnt = 0, bCnt = 0;
                for(int dx = 0; dx < 8; dx++){
                    for(int dy = 0; dy < 8; dy++){
                        if(board[dx + i][dy + j] != wFrame[dx][dy])
                            wCnt++;
                        if(board[dx + i][dy + j] != bFrame[dx][dy])
                            bCnt++;
                    }
                }
                min = Math.min(min, Math.min(wCnt, bCnt));
            }
        }

        System.out.println(min);
        br.close();
    }

}