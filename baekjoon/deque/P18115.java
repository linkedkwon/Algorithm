package baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P18115 {

    static int N;
    static int[] inst;
    static Deque<Integer> deq = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        for(int i : deq)
            sb.append(i).append(' ');
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inst = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            inst[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void process(){
        int dx = 1;
        for(int i = N - 1; i >= 0; i--){
            int op = inst[i];
            if(op == 1){
                deq.offerFirst(dx);
            }else if(op == 2){
                int tmp = deq.pollFirst();
                deq.offerFirst(dx);
                deq.offerFirst(tmp);
            }else{
                deq.offerLast(dx);
            }
            dx++;
        }
    }

}