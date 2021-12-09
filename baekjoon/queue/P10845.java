package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int back = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push": back = Integer.parseInt(st.nextToken()); queue.add(back); break;
                case "pop": sb.append(queue.isEmpty() ? "-1\n" : queue.poll()+"\n"); break;
                case "size": sb.append(queue.size()+"\n"); break;
                case "empty": sb.append(queue.isEmpty() ? "1\n" : "0\n"); break;
                case "front": sb.append(queue.isEmpty() ? "-1\n" : queue.peek()+"\n");break;
                case "back": sb.append(queue.isEmpty() ? "-1\n": back+"\n");break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}