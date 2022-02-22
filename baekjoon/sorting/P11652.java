package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11652 {

    static int N;
    static long MIN;
    static long[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        getMinValue();
        System.out.println(MIN);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        for(int i = 0; i < N; i++)
            arr[i] = Long.parseLong(br.readLine());
        br.close();
    }

    static void getMinValue(){
        MIN = arr[0];
        int cnt1 = 1, cnt2 = 1;
        for(int i = 0; i < N - 1; i++){
            cnt1 = arr[i] == arr[i + 1] ? cnt1 + 1 : 1;
            if(cnt1 > cnt2){
                cnt2 = cnt1;
                MIN = arr[i];
            }
        }
    }

}