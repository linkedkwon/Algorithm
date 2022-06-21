package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1672 {

    static final String[][] DNA = {{"A", "C", "A", "G"}, {"C", "G", "T", "A"},

                           {"A", "T", "C", "G"}, {"G", "A", "G", "T"}};
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
        System.out.println(sb);
    }

    static void preProcess() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb.append(br.readLine());

        br.close();
    }

    static void process(){
        int len = sb.length();
        while(len > 1) {
            int dx = getDNAIndex(sb.charAt(len - 2)), dy = getDNAIndex(sb.charAt(len - 1));
            sb.replace(len - 2, len, DNA[dx][dy]);
            len = sb.length();
        }

    }

    static int getDNAIndex(char c) {
        int idx = 0;
        switch (c) {
            case 'A': idx = 0; break;
            case 'G': idx = 1; break;
            case 'C': idx = 2; break;
            case 'T': idx = 3; break;
        }

        return idx;
    }

}