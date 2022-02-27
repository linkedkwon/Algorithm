package baekjoon.parametric_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2512 {

    static int N, M, MAX;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        bs();
        System.out.println(MAX);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        br.close();
    }

    static int getSumArr(int mid){
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i] <= mid ? arr[i] : mid;
        }
        return sum;
    }

    static void bs(){
        int left = 1, right = arr[N - 1];
        while(left <= right){
            int mid = (left + right) / 2;
            if(getSumArr(mid) > M){
                right = mid - 1;
            }else{
                MAX = mid;
                left = mid + 1;
            }
        }
    }

}