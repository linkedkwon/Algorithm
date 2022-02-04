package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int N, M, CNT = 0, MAX = 0;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static int[][] paper;
    private static Queue<Point> queue = new LinkedList();

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(paper[i][j] == 1){
                    queue.offer(new Point(i, j));
                    paper[i][j] = 0;
                    MAX = Math.max(MAX, bfs());
                    CNT++;
                }
            }
        }
        System.out.println(CNT + "\n" + MAX);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    public static int bfs(){
        int area = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            area++;

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= N || dy >= M || paper[dx][dy] == 0)
                    continue;
                queue.offer(new Point(dx, dy));
                paper[dx][dy] = 0;
            }
        }

        return area;
    }

}