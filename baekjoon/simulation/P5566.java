package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5566 {

    static int n, m, cnt = 0;
    static int[] board, dice;

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
        System.out.println(cnt);
    }

    static void preProcess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        board = new int[n + 1]; dice = new int[m];

        for(int i = 1; i <= n; i++)
            board[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++)
            dice[i] = Integer.parseInt(br.readLine());

        br.close();
    }

    static void process() {
        int dx = 1;
        for(int i = 0; i < m; i++) {
            dx += dice[i];
            if(dx >= n) {
                cnt = i + 1;
                break;
            }

            dx += board[dx];
            if(dx >= n) {
                cnt = i + 1;
                break;
            }

            if(dx < 0)
                dx = 0;
        }
    }

}