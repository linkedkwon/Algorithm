package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P1181 {

    static int N;
    static String[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        sort();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i = 0; i < N; i++)
            arr[i] = br.readLine();
        br.close();
    }

    static void sort(){
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() != s2.length()) return s1.length() - s2.length();
                else return s1.compareTo(s2);
            }
        });
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        for(String obj : arr) {
            if(tmp.equals(obj))
                continue;
            sb.append(obj).append('\n');
            tmp = obj;
        }
        System.out.println(sb);
    }

}