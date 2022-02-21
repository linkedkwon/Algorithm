package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1484 {

    static int G;
    static boolean[] arr = new boolean[100000];

    public static void main(String[] args) throws IOException{
        readIn();
        tp();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        br.close();
    }

    static void writeOut(){
        boolean hasDif = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 100000; i++) {
            if(arr[i]) {
                hasDif = true;
                sb.append(i).append('\n');
            }
        }
        System.out.println(hasDif ? sb : "-1");
    }

    static void tp(){
        int dx = 1, dy = 2;
        while(dx < dy){
            long dif = (long)(Math.pow(dy, 2) - Math.pow(dx, 2));
            if(dif < G)
                dy++;
            else if(dif == G)
                arr[dy++] = true;
            else
                dx++;
        }
    }

}