package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int[] t = new int[100001];
        queue.offer(N);
        t[N] = 1;

        while(!queue.isEmpty() && t[K] == 0){
            int e = queue.poll();
            int dx = e - 1, dy = e + 1, dz = e * 2;
            int time = t[e] + 1;

            if(dx >= 0 && t[dx] == 0){
                t[dx] = time;
                queue.add(dx);
            }
            if(dy < t.length && t[dy] == 0){
                t[dy] = time;
                queue.add(dy);
            }
            if(dz < t.length && t[dz] == 0){
                t[dz] = time;
                queue.add(dz);
            }
        }

        System.out.println(t[K] - 1);
        br.close();
    }

}