package baekjoon.bruteforcing;

import java.io.IOException;

public class P4673 {

    static boolean[] arr = new boolean[10001];

    public static void main(String[] args) throws IOException{
        bruteforce();
        writeOut();
    }

    static void bruteforce(){
        for(int i = 1; i < 10001; i++){
            int dx = i, n = i;
            while(dx > 0){
                n += dx % 10;
                dx /= 10;
            }
            if(n <= 10000)
                arr[n] = true;
        }
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 10001; i++){
            if(!arr[i])
                sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

}