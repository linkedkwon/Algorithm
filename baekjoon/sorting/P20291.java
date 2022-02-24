package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20291 {

    static class Pair implements Comparable<Pair>{
        String name, extension;

        public Pair(String name, String extension) {
            this.name = name;
            this.extension = extension;
        }

        @Override
        public int compareTo(Pair o) {
            return extension.compareTo(o.extension);
        }
    }

    static int N;
    static Pair[] pairs;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(pairs);
        countExtension();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pairs = new Pair[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            pairs[i] = new Pair(st.nextToken(), st.nextToken());
        }

        br.close();
    }

    static void countExtension(){
        String tmp = pairs[0].extension;
        int cnt = 1;

        for(int i = 1; i < N; i++){
            if(tmp.equals(pairs[i].extension))
                cnt++;
            else{
                sb.append(tmp + ' ' + cnt).append('\n');
                tmp = pairs[i].extension;
                cnt = 1;
            }
        }
        sb.append(cnt == 1 ? tmp + " 1" : tmp + " " + cnt).append('\n');
        System.out.println(sb);
    }

}