package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10814 {

    static class Pair implements Comparable<Pair>{
        int age;
        String name;

        public Pair(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Pair o) {
            return age - o.age;
        }

    }

    static int N;
    static Pair[] PAIRS;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(PAIRS);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PAIRS = new Pair[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            PAIRS[i] = new Pair(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        br.close();
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(Pair p : PAIRS)
            sb.append(p.age + " " + p.name).append('\n');

        System.out.println(sb);
    }

}