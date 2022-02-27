package baekjoon.parametric_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {

    static int N, C, MAX;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        bs();
        System.out.println(MAX);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        br.close();
    }

    static int getCountModem(int mid){
        int tmp = arr[0];
        int cnt = 1;
        for(int i = 0; i < N; i++){
            int dist = arr[i] - tmp;
            if(dist >= mid){
                cnt++;
                tmp = arr[i];
            }
        }

        return cnt;
    }

    static void bs(){
        int left = 1, right = arr[N - 1] - arr[0];
        while(left <= right){
            int mid = (left + right) / 2;
            if(getCountModem(mid) >= C) {
                MAX = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
    }

}