package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2251 {

    private static class Bottle{
        int a, b, c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    private static int A, B, C;
    private static boolean[][][] visited;
    private static Queue<Bottle> queue = new LinkedList<>();
    private static ArrayList<Integer> liter = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        Collections.sort(liter);

        StringBuilder sb = new StringBuilder();
        for(int e : liter)
            sb.append(e).append(" ");
        System.out.println(sb);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        visited = new boolean[A + 1][B + 1][C + 1];

        queue.offer(new Bottle(0, 0, C));
        br.close();
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Bottle b = queue.poll();
            if(visited[b.a][b.b][b.c])
                continue;
            visited[b.a][b.b][b.c] = true;

            if(b.a == 0)
                liter.add(b.c);

            if(b.a + b.b <= A) queue.offer(new Bottle(b.a + b.b, 0, b.c));
            else queue.offer(new Bottle(A, b.a + b.b - A, b.c));

            if(b.a + b.c <= A) queue.offer(new Bottle(b.a + b.c, b.b, 0));
            else queue.offer(new Bottle(A, b.b, b.a + b.c - A));

            if(b.a + b.b <= B) queue.offer(new Bottle(0, b.a + b.b, b.c));
            else queue.offer(new Bottle(b.a + b.b - B, B, b.c));

            if(b.b + b.c <= B) queue.offer(new Bottle(b.a, b.b + b.c, 0));
            else queue.offer(new Bottle(b.a, B, b.b + b.c - B));

            if(b.a + b.c <= C) queue.offer(new Bottle(0, b.b, b.a + b.c));
            else queue.offer(new Bottle(b.a + b.c - C, b.b, C));

            if(b.b + b.c <= C) queue.offer(new Bottle(b.a, 0, b.b + b.c));
            else queue.offer(new Bottle(b.a, b.b + b.c - C, C));
        }
    }

}