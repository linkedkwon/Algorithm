package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2947 {

    static int[] arr = new int[5];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        System.out.println(sb);
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void process(){
        int dx = 0;
        while(true){
            if(arr[dx] > arr[dx + 1]){
                int tmp = arr[dx];
                arr[dx] = arr[dx + 1];
                arr[dx + 1] = tmp;
                writeArray();
            }

            if(++dx == 4)
                dx = 0;
            if(checkSequence())
                break;
        }
    }

    static void writeArray(){
        for(int i = 0; i < 5; i++)
            sb.append(arr[i]).append(' ');
        sb.append('\n');
    }

    static boolean checkSequence(){
        for(int i = 0; i < 5; i++){
            if(arr[i] != i + 1)
                return false;
        }
        return true;
    }

}