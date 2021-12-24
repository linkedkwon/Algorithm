package baekjoon.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
           heap.add(Integer.parseInt(br.readLine()));

        int answer = 0;
        if(heap.size() > 1) {
            while (true) {
                int dx = heap.poll() + heap.poll();
                answer += dx;
                if (heap.size() == 0)
                    break;
                heap.add(dx);
            }
        }
        System.out.println(answer);
        br.close();
    }
}