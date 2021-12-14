package baekjoon.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.PriorityQueue;

//to do later hard coding by class
public class P1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0)
                sb.append(Optional.ofNullable(queue.poll()).orElseGet(()->{return 0;}) + "\n");
            else
                queue.add(x);
        }

        System.out.println(sb);
        br.close();
    }

}