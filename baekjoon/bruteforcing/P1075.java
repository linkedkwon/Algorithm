package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1075 {

    static int N, F;

    public static void main(String[] args) throws IOException{
        readIn();
        loop();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); F = Integer.parseInt(br.readLine());
        br.close();
    }

    static void loop(){
        int dx = N / 100 * 100;
        while(true){
            if(dx % F == 0)
                break;
            dx++;
        }

        int dy = dx % 100;
        System.out.println(dy < 10 ? "0" + dy : dy);
    }

}