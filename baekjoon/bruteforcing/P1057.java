package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1057 {

    static int n, dx, dy, ans = -1;

    public static void main(String[] args) throws IOException{
        readIn();
        match();
        System.out.println(ans);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); dx = Integer.parseInt(st.nextToken()); dy = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void match(){
        int round = 0;
        while(n > 0){
            n /= 2;
            dx = dx / 2 + dx % 2;
            dy = dy / 2 + dy % 2;
            round++;
            if(dx == dy) {
                ans = round;
                break;
            }
        }
    }

}