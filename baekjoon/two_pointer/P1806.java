package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {

    static int N, S, LEN = 100000;
    static int[] seq;

    public static void main(String[] args) throws IOException{
        readIn();
        twoPointer();
        System.out.println(LEN == 100000 ? 0 : LEN);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void twoPointer(){
        int dx = 0, dy = 0, sum = seq[0];
        while(true){
            if(sum >= S){
                LEN = Math.min(LEN, dy - dx + 1);
                sum -= seq[dx++];
            }else{
                if(++dy == N)
                    break;
                sum += seq[dy];
            }

            if (dx == dy && dx == N)
                break;
        }
    }

}