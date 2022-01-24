package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10026 {

    private static int N;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[][] field = new char[N][N];
        for(int i = 0; i < N; i++)
            field[i] = br.readLine().toCharArray();

        char[][] fieldBlind = new char[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                fieldBlind[i][j] = field[i][j] == 'G' ? 'R' : field[i][j];
        }

        boolean[][] visited = new boolean[N][N], visitedBlind = new boolean[N][N];

        int rgb = 0, blind = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(field, visited, i, j, field[i][j]);
                    rgb++;
                }
                if(!visitedBlind[i][j]){
                    dfs(fieldBlind, visitedBlind, i, j, fieldBlind[i][j]);
                    blind++;
                }
            }
        }
        System.out.println(rgb + " " + blind);
        br.close();
    }


    public static void dfs(char[][] field, boolean[][] visited, int i, int j, char color){
        visited[i][j] = true;

        for(int n = 0; n < 4; n++){
            int dx = i + x[n], dy = j + y[n];

            if(dx < 0 || dy < 0 || dx >= N || dy >= N)
                continue;
            if(field[dx][dy] == color && !visited[dx][dy])
                dfs(field, visited, dx, dy, color);

        }

    }

}