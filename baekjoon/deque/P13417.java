package baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P13417 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            Deque<Character> deq = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            deq.offer(st.nextToken().charAt(0));
            for(int i = 1; i < N; i++){
                char c = st.nextToken().charAt(0);
                if(c <= deq.peekFirst()) deq.offerFirst(c);
                else deq.offerLast(c);
            }

            for(char c : deq)
                sb.append(c);
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}