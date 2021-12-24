package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P18258 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new LinkedList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    deq.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(deq.isEmpty() ? "-1" : deq.poll()).append("\n");
                    break;
                case "size":
                    sb.append(deq.size() + "\n");
                    break;
                case "empty":
                    sb.append(deq.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front":
                    sb.append(deq.isEmpty() ? "-1" : deq.peek()).append("\n");
                    break;
                case "back":
                    sb.append(deq.isEmpty() ? "-1" : deq.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}