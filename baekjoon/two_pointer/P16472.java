package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16472{

    static int N, LEN;
    static String str;
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException{
        readIn();
        tp();
        System.out.println(LEN);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        br.close();
    }

    static void tp(){
        int dy = 0, cnt = 0;
        for(int dx = 0; dx < str.length(); dx++){
            while(cnt <= N && dy < str.length()){
                int idy = str.charAt(dy) - 97;
                if(alpha[idy] == 0){
                    if(cnt + 1 > N) break;
                    else cnt++;
                }
                alpha[idy]++;
                dy++;
            }

            LEN = Math.max(LEN, dy - dx);
            if(dy == str.length())
                break;
            if(--alpha[str.charAt(dx) - 97] == 0)
                cnt--;
        }
    }

}