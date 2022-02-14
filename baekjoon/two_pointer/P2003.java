package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {

    static int N, M, CNT;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        getMatchSum();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void getMatchSum(){
        int dx = 0, dy = 0, sum = 0;
        while(dy <= N){
            if(sum > M)
                sum -= arr[dx++];
            else if(sum == M){
                sum -= arr[dx++];
                CNT++;
            }else
                sum += arr[dy++];
        }
    }

}