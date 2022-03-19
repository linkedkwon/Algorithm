package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P12761 {

    static class Pair{
        int dx, cnt;

        public Pair(int dx, int cnt) {
            this.dx = dx;
            this.cnt = cnt;
        }
    }
    static int A, B, N, M;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(N, 0));
        visited[N] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.dx == M){
                System.out.println(p.cnt);
                System.exit(0);
            }
            for(int d = 0; d < 8; d++){
                int dx = p.dx, dy = p.cnt + 1;
                if(d == 0) dx -= 1;
                else if(d == 1) dx += 1;
                else if(d == 2) dx -= A;
                else if(d == 3) dx += A;
                else if(d == 4) dx -= B;
                else if(d == 5) dx += B;
                else if(d == 6) dx *= A;
                else if(d == 7) dx *= B;

                if(dx < 0 || dx > 100000 || visited[dx])
                    continue;
                queue.offer(new Pair(dx, dy));
                visited[dx] = true;
            }
        }
    }

}