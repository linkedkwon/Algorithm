package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3040 {

    static int sum = 0;
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException{
        readIn();
        loop();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        br.close();
    }

    static void writeOut(int n1, int n2){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            if(arr[i] == n1 || arr[i] == n2)
                continue;
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
        System.exit(0);
    }

    static void loop(){
        for(int i = 0; i < 9; i++){
            for(int j = i + 1; j < 9; j++){
                int dx = sum - arr[i] - arr[j];
                if(dx > 100)
                    continue;
                else if(dx == 100)
                    writeOut(arr[i], arr[j]);
            }
        }
    }

}