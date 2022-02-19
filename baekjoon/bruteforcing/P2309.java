package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2309 {

    static int sum, dx, dy;
    static int[] arr = new int[9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        bruteforce();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        br.close();
    }

    static void writeOut(){
        for(int i = 0; i < 9; i++) {
            if(i == dx || i == dy)
                continue;
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void bruteforce(){
        boolean hasFound = false;
        for(int i = 0; i < 9; i++){
            if(hasFound) break;
            for(int j = i + 1; j < 9; j++){
                if(sum - arr[i] - arr[j] == 100){
                    dx = i; dy = j;
                    hasFound = true;
                    break;
                }
            }
        }
    }

}