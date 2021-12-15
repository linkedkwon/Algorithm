package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Deque<Integer> deq = new LinkedList<>();
        for(int i = 1; i < N + 1; i++)
            deq.add(i);

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < M; i++) {
            int e = Integer.parseInt(st.nextToken()), dx = 0, dy;
            for(int o : deq){
                if(o == e)
                    break;
                dx++;
            }

            dy = deq.size() - dx;
            boolean isFront = dx < dy ? true : false;
            cnt += Math.min(dx, dy);

            while(true){
                int num = isFront ? deq.pollFirst() : deq.pollLast();
                if(num == e)
                    break;
                if(isFront)
                    deq.addLast(num);
                else
                    deq.addFirst(num);
            }
        }

        System.out.println(cnt);
        br.close();
    }

}