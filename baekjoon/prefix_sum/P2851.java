package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2851 {

    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException{
        readIn();
        getPrefixSum();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += Integer.parseInt(br.readLine());
            arr[i] = sum;
        }
        br.close();
    }

    static void getPrefixSum(){
        int difMin = Integer.MAX_VALUE, ans = 0;
        for(int i = 0; i < 10; i++){
            int dif = Math.abs(arr[i] - 100);
            if(difMin >= dif){
                difMin = dif;
                ans = arr[i];
            }
        }
        System.out.println(ans);
    }

}