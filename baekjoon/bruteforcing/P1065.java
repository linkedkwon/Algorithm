package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1065 {

    static int N, CNT;

    public static void main(String[] args) throws IOException{
        readIn();
        checkSequence();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    static void checkSequence(){
        if(N < 100){
            CNT = N;
        }else{
            CNT = 99;
            for(int i = 100; i <= N; i++){
                int dx = i / 10, dy = dx % 10, d = dy - i % 10;
                dx /= 10;
                while(dx > 0){
                    int dz = dx % 10;
                    if(d != dz - dy)
                        break;
                    dy = dz;
                    dx /= 10;
                }
                if(dx == 0)
                    CNT++;
            }
        }
    }

}