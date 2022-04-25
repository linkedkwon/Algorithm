package baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P2346 {

    static class Pair{
        int dx, dy;

        public Pair(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }
    static int N;
    static Deque<Pair> deq = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            deq.offer(new Pair(i, Integer.parseInt(st.nextToken())));
        br.close();
    }

    static void process(){
        Pair startObj = deq.pollFirst();
        int dx = startObj.dx, dy = startObj.dy;
        sb.append(dx).append(' ');

        while(!deq.isEmpty()){
            Pair obj;
            if(dy > 0){
                dy = (dy - 1) % deq.size();
                for(int i = 0; i < dy; i++)
                    deq.offerLast(deq.pollFirst());
                obj = deq.pollFirst();
            }else{
                dy = Math.abs(dy + 1) % deq.size();
                for(int i = 0; i < dy; i++)
                    deq.offerFirst(deq.pollLast());
                obj = deq.pollLast();
            }

            dx = obj.dx; dy = obj.dy;
            sb.append(dx).append(' ');
        }
    }

}