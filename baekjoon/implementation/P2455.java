package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2455 {

    static int maxCnt;
    static int[][] onOffCnt = new int[4][2];

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        System.out.println(maxCnt);
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            onOffCnt[i][0] = Integer.parseInt(st.nextToken());
            onOffCnt[i][1] = Integer.parseInt(st.nextToken());
        }

        maxCnt = onOffCnt[0][1];
        br.close();
    }

    static void process(){
        int cnt = onOffCnt[0][1];
        for(int i = 1; i < 4; i++){
            cnt = cnt - onOffCnt[i][0] + onOffCnt[i][1];
            maxCnt = Math.max(maxCnt, cnt);
        }

    }

}