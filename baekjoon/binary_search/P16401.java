package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16401 {

    static int N, M, MAX, left = 0, right = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        bs();
        System.out.println(MAX);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }
        br.close();
    }

    static boolean hasGivenSnack(int len){
        if(len == 0)
            return true;
        int cnt = 0;
        for(int i = M - 1; i >= 0; i--){
            cnt += arr[i] / len;
            if(cnt >= N)
                return true;
        }
        return false;
    }

    static void bs(){
        while(left <= right){
            int mid = (left + right) / 2;
            if(hasGivenSnack(mid)){
                left = mid + 1;
                MAX = mid;
            }else
                right = mid - 1;
        }
    }

}