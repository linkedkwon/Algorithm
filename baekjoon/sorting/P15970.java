package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15970 {

    static class Pair implements Comparable<Pair>{
        int dx, color;

        public Pair(int dx, int color) {
            this.dx = dx;
            this.color = color;
        }

        @Override
        public int compareTo(Pair o) {
            return color == o.color ? dx - o.dx : color - o.color;
        }
    }

    static int N;
    static long SUM;
    static Pair[] pairs;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(pairs);
        connectLines();
        System.out.println(SUM);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pairs = new Pair[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    static void connectLines(){
        Pair p = pairs[0];
        SUM += p.color == pairs[1].color ? Math.abs(p.dx - pairs[1].dx) : 0;

        for(int i = 1; i < N - 1; i++){
            int dist1 = Integer.MAX_VALUE, dist2 = Integer.MAX_VALUE;
            if(p.color == pairs[i].color) dist1 = Math.abs(p.dx - pairs[i].dx);
            if(pairs[i].color == pairs[i + 1].color) dist2 = Math.abs(pairs[i].dx - pairs[i + 1].dx);

            SUM += Math.min(dist1, dist2);
            p = pairs[i];
        }

        SUM += p.color == pairs[N - 1].color ? Math.abs(p.dx - pairs[N - 1].dx) : 0;
    }
}