package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P2870 {

    static class Pair implements Comparable<Pair>{
        String str;

        public Pair(String str) {
            this.str = str;
        }

        @Override
        public int compareTo(Pair pair) {
            String obj = pair.str;
            return str.length() == obj.length() ? str.compareTo(obj) : str.length() - obj.length();
        }
    }

    static String read, sub;
    static ArrayList<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            read = br.readLine();
            parseStr();
        }
        writeOut();
        br.close();
    }

    static void parseStr(){
        int len = read.length();
        sub = "";
        for(int i = 0; i < len; i++){
            char c = read.charAt(i);
            if(c >= 48 && c <= 57){
                sub += c;
            }else{
                if(sub.length() > 0){
                    removeZeroFromFront();
                    list.add(new Pair(sub));
                    sub = "";
                }
            }
        }

        if(sub.length() > 0){
            removeZeroFromFront();
            list.add(new Pair(sub));
        }
    }

    static void removeZeroFromFront(){
        int len = sub.length(), dx = 0;
        if(len < 2)
            return;
        for(int i = 0; i < len - 1; i++){
            if(sub.charAt(i) == '0') dx++;
            else break;
        }
        sub = sub.substring(dx);
    }

    static void writeOut(){
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Pair obj : list)
            sb.append(obj.str).append('\n');

        System.out.println(sb);
    }

}