package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1644 {

    static int N, CNT;
    static boolean[] prime;

    public static void main(String[] args) throws IOException{
        readIn();
        initPrimeNumber();
        tp();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prime = new boolean[N + 10];
        br.close();
    }

    static void initPrimeNumber(){
        for(int i = 2; i * i <= N; i++){
            if(!prime[i]){
                for(int j = i * i; j <= N; j += i)
                    prime[j] = true;
            }
        }
    }

    static void tp(){
        int dx = 2, dy = 2, sum = 0;
        while(dx <= N){
            if(prime[dx]){
                dx++;
                continue;
            }
            if(prime[dy]){
                dy++;
                continue;
            }

            if(sum == N) {
                CNT++;
                sum += dy++;
            }
            else if(sum < N)
                sum += dy++;
            else
                sum -= dx++;
        }
    }

}