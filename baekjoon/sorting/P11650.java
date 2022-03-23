package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11650{

    static class Pair implements Comparable<Pair>{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return x - o.x == 0 ? y - o.y : x - o.x;
        }
    }
    static int N;
    static Pair[] pairs;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(pairs);
        writeOut();
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

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(Pair obj : pairs)
            sb.append(obj.x + " " + obj.y).append('\n');
        System.out.println(sb);
    }

}