package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P14226 {

    static class Pair{
        int emo, clip, t;

        public Pair(int emo, int clip, int t) {
            this.emo = emo;
            this.clip = clip;
            this.t = t;
        }
    }
    static int S;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[2001][2001];
        br.close();
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 0, 0));
        visited[1][0] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.emo == S){
                System.out.println(p.t);
                System.exit(0);
            }
            for(int d = 0; d < 3; d++){
                int dx = p.emo, dy = p.clip, dz = p.t + 1;
                if(d == 0) dx += dy;
                else if(d == 1) dy = p.emo;
                else dx--;

                if(dx > 2000 || dx < 0 || dy > 2000 || dy == 0 || visited[dx][dy])
                    continue;
                queue.offer(new Pair(dx, dy, dz));
                visited[dx][dy] = true;
            }
        }
    }

}