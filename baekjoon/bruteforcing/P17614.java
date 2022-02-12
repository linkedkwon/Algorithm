package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17614 {

    static int N, CNT;

    public static void main(String[] args) throws IOException{
        readIn();
        loop();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    static void loop(){
        for(int i = 3; i <= N; i++){
            int dx = i;
            while(dx > 0){
                int r = dx % 10;
                if(r == 3 || r == 6 || r == 9)
                    CNT++;
                dx /= 10;
            }
        }
    }

}