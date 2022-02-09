package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {

    static int N, D = Integer.MAX_VALUE, A, B;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        twoPointer();
        System.out.println(arr[A] + " " + arr[B]);
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

    static void twoPointer(){
        int dx = 0, dy = N - 1;
        while(dx != dy){
            int d = arr[dx] + arr[dy];

            if(D > Math.abs(d)){
                D = Math.abs(d);
                A = dx; B = dy;
            }

            if(d == 0){
                A = dx; B = dy;
                break;
            }else if(d < 0){
                dx++;
            }else{
                dy--;
            }
        }
    }

}