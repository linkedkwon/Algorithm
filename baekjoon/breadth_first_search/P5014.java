package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014 {

    private static class Floor{
        int floor, cnt;

        public Floor(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }

    private static int F, S, G, U, D, answer = -1;
    private static boolean[] visited;
    private static Queue<Floor> queue;

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        System.out.println(answer == -1 ? "use the stairs" : answer);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken()); G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken()); D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];
        queue = new LinkedList<>();
        queue.offer(new Floor(S, 0));
        visited[S] = true;

        br.close();
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Floor f = queue.poll();
            if(f.floor == G){
                answer = f.cnt;
                break;
            }
            int dx = f.floor + U, dy = f.floor - D;
            if(dx <= F && !visited[dx]) {
                queue.offer(new Floor(dx, f.cnt + 1));
                visited[dx] = true;
            }
            if(dy > 0 && !visited[dy]) {
                queue.offer(new Floor(dy, f.cnt + 1));
                visited[dy] = true;
            }
        }
    }

}