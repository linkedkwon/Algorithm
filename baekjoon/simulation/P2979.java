package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2979 {

    static int a, b, c, max, cost;
    static int[] cnt = new int[101];

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        System.out.println(cost);
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            for(int j = x; j < y; j++)
                cnt[j]++;
            max = Math.max(max, y);
        }

        br.close();
    }

    static void process(){
        for(int i = 1; i <= max; i++){
            int dx = cnt[i];
            switch (dx){
                case 1: cost += a * dx; break;
                case 2: cost += b * dx; break;
                case 3: cost += c * dx; break;
            }
        }
    }

}