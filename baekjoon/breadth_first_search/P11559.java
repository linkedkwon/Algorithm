package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P11559 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int CNT = 0;
    static int[] x= {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static char[][] board = new char[12][6];
    static boolean[][] visited;
    static boolean hasNext = true;

    public static void main(String[] args) throws IOException{
        readIn();
        while(hasNext){
            visited = new boolean[12][6];
            hasNext = false;
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(board[i][j] != '.' && !visited[i][j]){
                        visited[i][j] = true;
                        bfs(i, j, board[i][j]);
                    }
                }
            }
            dropBlock();
            CNT++;
        }
        System.out.println(CNT - 1);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 12; i++)
            board[i] = br.readLine().toCharArray();
        br.close();
    }

    static void bfs(int i, int j, char c){
        ArrayList<Pair> block = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        block.add(new Pair(i, j));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= 12 || dy >= 6)
                    continue;
                if(visited[dx][dy] || board[dx][dy] != c)
                    continue;
                queue.offer(new Pair(dx, dy));
                block.add(new Pair(dx, dy));
                visited[dx][dy] = true;
            }
        }

        if(block.size() < 4)
            return;
        hasNext = true;
        for(Pair p : block)
            board[p.x][p.y] = '.';
    }

    static void dropBlock(){
        for(int i = 0; i < 6; i++){
            String str = "";
            for(int j = 11; j >= 0; j--){
                if(board[j][i] != '.') {
                    str += board[j][i];
                    board[j][i] = '.';
                }
            }

            int dx = 11;
            for(int j = 0; j < str.length(); j++)
                board[dx--][i] = str.charAt(j);
        }
    }

}