package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P2178 {

    public static class Coordinate{
        int x;
        int y;

        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N + 1][M + 1];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++)
                map[i + 1][j + 1] = str.charAt(j);
        }

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(1, 1));

        int[][] visited = new int[N + 1][M + 1];
        visited[1][1] = 1;

        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            Coordinate obj = queue.poll();
            for(int i = 0; i < 4; i++){
                int dx = obj.x + x[i], dy = obj.y + y[i];
                if(dx > N || dx < 1 || dy > M || dy < 1)
                    continue;
                if(map[dx][dy] == '1' && visited[dx][dy] < 1){
                    queue.offer(new Coordinate(dx, dy));
                    visited[dx][dy] = visited[obj.x][obj.y] + 1;
                }
            }
        }

        System.out.println(visited[N][M]);
        br.close();
    }

}