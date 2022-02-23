package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1015 {

    static class Pair implements Comparable<Pair>{
        int dx, e;

        public Pair(int dx, int e) {
            this.dx = dx;
            this.e = e;
        }

        @Override
        public int compareTo(Pair o) {
            return e - o.e;
        }
    }

    static int N;
    static int[] p;
    static Pair[] pairs;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(pairs);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N]; pairs = new Pair[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            pairs[i] = new Pair(i, Integer.parseInt(st.nextToken()));

        br.close();
    }

    static void writeOut(){
        int dx = 0;
        for(Pair obj : pairs)
            p[obj.dx] = dx++;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(p[i]).append(' ');

        System.out.println(sb);
    }

}