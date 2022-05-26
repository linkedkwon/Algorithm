package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2810 {

    static int N, CNT = 1;
    static String STR;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println(CNT > N ? N : CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        STR = br.readLine();
        br.close();
    }

    static void process(){
        for(int i = 0; i < N; i++){
            char c = STR.charAt(i);

            if(c == 'S'){
                CNT++;
            }
            else{
                i++;
                CNT++;
            }
        }
    }

}