package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5635 {

    static class Pair implements Comparable<Pair>{
        String name;
        int year, month, day;

        public Pair(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Pair o) {
            if(year != o.year)
                return o.year - year;
            if(month != o.month)
                return o.month - month;
            return o.day - day;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(pairs);

        System.out.println(pairs[0].name + "\n" + pairs[N - 1].name);
        br.close();
    }

}