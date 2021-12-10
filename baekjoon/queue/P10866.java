package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//dequeue
public class P10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deq = new LinkedList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push_front":
                    deq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deq.isEmpty() ? "-1\n" : deq.pollFirst() + "\n");
                    break;
                case "pop_back":
                    sb.append(deq.isEmpty() ? "-1\n" : deq.pollLast() + "\n");
                    break;
                case "size":
                    sb.append(deq.size() + "\n");
                    break;
                case "empty":
                    sb.append(deq.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    sb.append(deq.isEmpty() ? "-1\n" : deq.peekFirst() + "\n");
                    break;
                case "back":
                    sb.append(deq.isEmpty() ? "-1\n" : deq.peekLast() + "\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}