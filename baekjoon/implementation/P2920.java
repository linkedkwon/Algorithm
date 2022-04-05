package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2920 {

    static int[] arr = new int[8];
    public static void main(String[] args) throws IOException{
        readIn();
        checkOrder();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 8; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void checkOrder(){
        int dx = 0, dy = 0;
        for(int i = 0; i < 8; i++){
            if(i + 1 == arr[i]) dx++;
            if(8 - i == arr[i]) dy++;
        }

        if(dx == 8) System.out.println("ascending");
        else if(dy == 8) System.out.println("descending");
        else System.out.println("mixed");
    }

}