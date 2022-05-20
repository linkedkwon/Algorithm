package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1755 {

    static class Word implements Comparable<Word>{
        String str;
        int i;

        public Word(String str, int i) {
            this.str = str;
            this.i = i;
        }

        @Override
        public int compareTo(Word o) {
            return str.compareTo(o.str);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Word> arr = new ArrayList<>();
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        String[] num = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = M; i <= N; i++)
            arr.add(new Word(i < 10 ? num[i] : num[i / 10] + num[i % 10], i));

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        int len = arr.size();
        for(int i = 0; i < len; i++){
            if(i != 0 && i % 10 == 0)
                sb.append('\n');
            sb.append(arr.get(i).i).append(' ');
        }

        System.out.println(sb);
        br.close();
    }
}