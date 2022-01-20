package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2231 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int min = 0;
        for(int i = 0; i < N; i++){
            int j = i, sum = 0;
            while(j != 0){
                sum += j % 10;
                j /= 10;
            }
            if(i + sum == N) {
                min = i;
                break;
            }
        }

        System.out.println(min);
        br.close();
    }

}