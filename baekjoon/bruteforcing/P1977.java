package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1977 {

    static int M, N, SUM, MIN;

    public static void main(String[] args) throws IOException{
        readIn();
        searchSquare();
        System.out.println(SUM == 0 ? "-1" : SUM + "\n" + MIN);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine()); N = Integer.parseInt(br.readLine());
        br.close();
    }

    static void searchSquare(){
        boolean hasMin = false;
        for(int i = 1; i <= 100; i++){
            int sqrt = i * i;
            if(sqrt >= M && sqrt <= N) {
                SUM += sqrt;
                if(!hasMin) {
                    MIN = sqrt;
                    hasMin = true;
                }
            }
            else if(sqrt > N)
                break;
        }
    }

}