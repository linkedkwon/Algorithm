package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1987 {

    private static int R, C, max = 0;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static boolean[] alpha;
    private static char[][] board;

    public static void main(String[] args) throws IOException{
        readIn();
        backtracking(0, 0, 1);
        System.out.println(max);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i = 0; i < R; i++)
            board[i] = br.readLine().toCharArray();

        alpha = new boolean[26];
        br.close();
    }

    public static void backtracking(int i, int j, int cnt){
        alpha[board[i][j] - 65] = true;

        for(int d = 0; d < 4; d++){
            int dx = i + x[d], dy = j + y[d];
            if(dx < 0 || dy < 0 || dx >= R || dy >= C)
                continue;
            if(!alpha[board[dx][dy] - 65]) {
                backtracking(dx, dy, cnt + 1);
            }
        }

        alpha[board[i][j] - 65] = false;
        max = Math.max(max, cnt);
    }

}