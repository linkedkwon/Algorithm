package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] box = new int[M + 1][N + 1];
        Queue<Point> queue = new LinkedList<>();
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1)
                    queue.add(new Point(i, j));
            }
        }

        int cnt = 0;
        int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            ArrayList<Point> arr = new ArrayList<>();
            while(!queue.isEmpty()){
                arr.add(queue.poll());
            }

            for(Point p : arr){
                for(int i = 0; i < 4; i++){
                    int dx = p.x + x[i], dy = p.y + y[i];

                    if(dx < 1 || dy < 1 || dx > M || dy > N)
                        continue;
                    if(box[dx][dy] == 0) {
                        queue.offer(new Point(dx, dy));
                        box[dx][dy] = 1;
                    }
                }
            }
            cnt++;
        }

        boolean hasRipen = true;
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(box[i][j] == 0) {
                    hasRipen = false;
                    break;
                }
            }
            if(!hasRipen)
                break;
        }

        System.out.println(hasRipen ? cnt - 1 : "-1");
        br.close();
    }
}