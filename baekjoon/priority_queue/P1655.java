package baekjoon.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder()),
                               maxHeap = new PriorityQueue<>();
        minHeap.add(Integer.parseInt(br.readLine()));
        sb.append(minHeap.peek() + "\n");

        for(int i = 1; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x < minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(x);
            }
            else {
                maxHeap.add(x);
            }

            if(minHeap.size() + 2 < maxHeap.size())
                minHeap.add(maxHeap.poll());

            sb.append(minHeap.size() == maxHeap.size() ? minHeap.peek() : maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}