package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {

    static int N, M, MAX;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};

    static int[][] dx = {{0, 1, 0}, {1, 1, 2}, {1, 1, 1}, {1, 1, 2}},
            dy = {{1, 1, 2}, {0, 1, 0}, {0, -1, 1}, {0, -1, 0}};

    static boolean[][] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(MAX);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M]; visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static void process(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(1, i, j, arr[i][j]);
                visited[i][j] = false;
                putFigure(i, j);
            }
        }
    }

    static void dfs(int depth, int i, int j, int sum){
        if(depth == 4){
            MAX = Math.max(MAX, sum);
            return;
        }

        for(int d = 0; d < 4; d++){
            int dx = i + x[d], dy = j + y[d];
            if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy])
                continue;
            visited[dx][dy] = true;
            dfs(depth + 1, dx, dy, sum + arr[dx][dy]);
            visited[dx][dy] = false;
        }
    }

    static void putFigure(int i, int j){
        for(int k = 0; k < 4; k++){
            boolean hasPut = true;
            int sum = arr[i][j];
            for(int d = 0; d < 3; d++){
                int x = i + dx[k][d], y = j + dy[k][d];
                if(x < 0 || y < 0 || x >= N || y >= M) {
                    hasPut = false;
                    break;
                }
                sum += arr[x][y];
            }
            if(hasPut) MAX = Math.max(MAX, sum);
        }
    }

}