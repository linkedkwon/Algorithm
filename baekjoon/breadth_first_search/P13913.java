package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P13913 {

    static class Pair{
        int dx, t;

        public Pair(int dx, int t) {
            this.dx = dx;
            this.t = t;
        }
    }
    static int N, K, LEN;
    static boolean[] visited;
    static int[] path;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        LEN = Math.max(N, K) + 2;
        visited = new boolean[LEN]; path = new int[LEN];
        br.close();
    }

    static void writeOut(){
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int i = K;
        while(i != N){
            stack.push(path[i]);
            i = path[i];
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(N, 0));
        visited[N] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.dx == K) {
                sb.append(p.t).append('\n');
                return;
            }

            for(int d = 0; d < 3; d++){
                int dx = p.dx;
                if(d == 0) dx += 1;
                else if(d == 1) dx -= 1;
                else dx *= 2;

                if(dx < 0 || dx >= LEN || visited[dx])
                    continue;
                visited[dx] = true;
                queue.offer(new Pair(dx, p.t + 1));
                path[dx] = p.dx;
            }
        }
    }

}