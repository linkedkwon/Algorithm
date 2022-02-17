package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2467 {

    static int N, idx, idy, MAX = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        tp();
        System.out.println(arr[idx] + " " + arr[idy]);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void tp(){
        int dx = 0, dy = N - 1;
        while(dx < dy){
            int sum = arr[dx] + arr[dy];
            int abs = Math.abs(sum);
            if(MAX > abs){
                MAX = abs;
                idx = dx; idy = dy;
            }
            if(sum == 0){
                idx = dx; idy = dy;
                break;
            }else if(sum > 0)
                dy--;
            else
                dx++;
        }
    }

}