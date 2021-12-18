package baekjoon.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//heap -> comparable sorting
public class P11286 {

    public static class Heap implements Comparable<Heap>{
        int abs;
        int num;

        public Heap(int abs, int num){
            this.abs = abs;
            this.num = num;
        }

        @Override
        public int compareTo(Heap o){
            return this.abs == o.abs ? this.num - o.num : this.abs - o.abs;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Heap> heap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0)
                sb.append(heap.isEmpty() ? 0 + "\n" : heap.poll().num + "\n");
            else
                heap.add(new Heap(Math.abs(x), x));
        }

        System.out.println(sb);
        br.close();
    }
}