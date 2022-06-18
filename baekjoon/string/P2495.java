package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2495 {

    static String[] arr = new String[3];
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        postProcess();
    }

    static void preProcess() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++)
            arr[i] = br.readLine();

        br.close();
    }

    static void process(){

        for(int i = 0; i < 3; i++){

            String str = arr[i];
            int len = str.length();
            char tmpCh = str.charAt(0);
            int maxCnt = 1, tmpCnt = 1;

            for(int j = 1; j < len; j++){
                char c = str.charAt(j);
                if(tmpCh == c) {
                    tmpCnt++;
                }
                else{
                    maxCnt = Math.max(maxCnt, tmpCnt);
                    tmpCnt = 1;
                    tmpCh = c;
                }
            }
            maxCnt = Math.max(maxCnt, tmpCnt);
            cnt[i] = maxCnt;
        }

    }

    static void postProcess(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++)
            sb.append(cnt[i]).append('\n');

        System.out.println(sb);
    }

}