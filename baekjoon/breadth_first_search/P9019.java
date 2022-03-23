package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9019 {

    static class Pair{
        int n;
        String inst;

        public Pair(int n, String inst) {
            this.n = n;
            this.inst = inst;
        }
    }
    static int A, B;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            readIn();
            bfs();
        }
        System.out.println(sb);
        br.close();
    }

    static void readIn() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());
        visited = new boolean[10000];
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(A, ""));
        visited[A] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int d = 0; d < 4; d++){
                int dx = p.n; String dy = p.inst;
                if(d == 0){
                    dx *= 2;
                    dx %= 10000;
                    dy += "D";
                }else if(d == 1){
                    if(dx == 0)
                        dx = 9999;
                    else
                        dx -= 1;
                    dy += "S";
                }else if(d == 2){
                    int r = dx / 1000;
                    dx %= 1000;
                    dx = dx * 10 + r;
                    dy += "L";
                }else{
                    int q = dx % 10;
                    dx = q * 1000 + dx / 10;
                    dy += "R";
                }

                if(dx == B){
                    sb.append(dy).append('\n');
                    return;
                }
                if(visited[dx])
                    continue;
                queue.offer(new Pair(dx, dy));
                visited[dx] = true;
            }
        }
    }

}