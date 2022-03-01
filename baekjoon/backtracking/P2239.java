package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P2239 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] board = new int[9][9];
    static ArrayList<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(0);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            String in = br.readLine();
            for(int j = 0; j < 9; j++) {
                board[i][j] = in.charAt(j) - '0';
                if(board[i][j] == 0)
                    pairs.add(new Pair(i, j));
            }
        }
        N = pairs.size();
        br.close();
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++)
                sb.append(board[i][j]);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static boolean isMatched(int x, int y, int value){
        for(int i = 0; i < 9; i++){
            if(board[x][i] == value || board[i][y] == value)
                return false;
        }

        int row = x / 3 * 3, col = y / 3 * 3;
        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                if(board[i][j] == value)
                    return false;
            }
        }

        return true;
    }

    static boolean dfs(int depth){
        if(depth == N)
            return true;

        Pair p = pairs.get(depth);
        for(int i = 1; i <=9; i++){
            if(isMatched(p.x, p.y, i)){
                board[p.x][p.y] = i;
                if(dfs(depth + 1)) return true;
                else board[p.x][p.y] = 0;
            }
        }
        return false;
    }

}