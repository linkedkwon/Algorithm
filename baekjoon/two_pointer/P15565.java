package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15565 {

    static int N, K, MIN;
    static int[] dolls;

    public static void main(String[] args) throws IOException{
        readIn();
        tp();
        System.out.println(MIN == N + 1 ? -1 : MIN);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        MIN = N + 1;
        dolls = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            dolls[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void tp(){
        int dx = 0, dy = 0, cnt = 0;
        while(dx < N){
            if(cnt < K){
                if(dy == N) break;
                if(dolls[dy++] == 1)
                    cnt++;
            }else{
                MIN = Math.min(MIN, dy - dx);
                if(dolls[dx++] == 1)
                    cnt--;
            }
        }
    }

}