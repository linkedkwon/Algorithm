package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14395 {

    static class Pair{
        long n;
        String o;

        public Pair(long n, String o) {
            this.n = n;
            this.o = o;
        }
    }
    static int S, T;
    static String CAL = "";
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        readIn();
        if(S == T)
            System.out.println("0");
        else {
            bfs();
            if (CAL.equals(""))
                System.out.println("-1");
            else writeOut();
        }
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); T = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(S, ""));
        set.add(Integer.toString(S));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.n == T){
                CAL = p.o;
                break;
            }
            for(int i = 0; i < 4; i++){
                long dx = p.n; String dy = p.o;
                switch(i){
                    case 0: dx *= dx; dy += "1";break;
                    case 1: dx += dx; dy += "2";break;
                    case 2: dx -= dx; dy += "3";break;
                    case 3: dx /= dx; dy += "4";break;
                }
                String num = Long.toString(dx);
                if(dx <= 0 || set.contains(num))
                    continue;
                set.add(num);
                queue.offer(new Pair(dx, dy));
            }
        }
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        String str = CAL;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            switch (c){
                case '1': sb.append('*');break;
                case '2': sb.append('+');break;
                case '3': sb.append('-');break;
                case '4': sb.append('/');break;
            }
        }
        System.out.println(sb);
    }

}