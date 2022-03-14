package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3197 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int R, C;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] visited;
    static Pair[] swan = new Pair[2];
    static Queue<Pair> queue = new LinkedList<>(), water = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        queue.offer(swan[0]);
        visited[swan[0].x][swan[0].y] = true;
        int day = 0;
        boolean hasMet = false;
        while(true){
            Queue<Pair> next = new LinkedList<>();
            while(!queue.isEmpty()){
                Pair p = queue.poll();
                if(p.x == swan[1].x && p.y == swan[1].y){
                    hasMet = true;
                    break;
                }

                for(int d = 0; d < 4; d++){
                    int dx = p.x + x[d], dy = p.y + y[d];
                    if(dx < 0 || dy < 0 || dx >= R || dy >= C || visited[dx][dy])
                        continue;

                    visited[dx][dy] = true;
                    if(arr[dx][dy] == 'X') {
                        next.offer(new Pair(dx, dy));
                        continue;
                    }
                    queue.offer(new Pair(dx, dy));
                }
            }
            if(hasMet) break;
            queue = next;

            int len = water.size();
            for(int i = 0; i < len; i++){
                Pair p = water.poll();
                for(int d = 0; d < 4; d++){
                    int dx = p.x + x[d], dy = p.y + y[d];
                    if(dx < 0 || dy < 0 || dx >= R || dy >= C)
                        continue;
                    if(arr[dx][dy] == 'X'){
                        arr[dx][dy] = '.';
                        water.offer(new Pair(dx, dy));
                    }
                }
            }
            day++;
        }
        System.out.println(day);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        arr = new char[R][C]; visited = new boolean[R][C];

        int dx = 0;
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                char c = str.charAt(j);
                arr[i][j] = c;
                if(c == 'L')
                    swan[dx++] = new Pair(i, j);
                if(c != 'X')
                    water.offer(new Pair(i, j));
            }
        }
        br.close();
    }

}