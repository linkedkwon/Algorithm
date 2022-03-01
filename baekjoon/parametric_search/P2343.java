package baekjoon.parametric_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343 {

    static int N, M;
    static int left, right;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        bs();
        System.out.println(left);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            left = left < arr[i] ? arr[i] :left;
            right += arr[i];
        }
        br.close();
    }

    static int isMatched(int mid){
        int tmp = 0, cnt = 0;
        for(int i = 0; i < N; i++){
            if(tmp + arr[i] > mid) {
                tmp = 0;
                cnt++;
            }
            tmp += arr[i];
        }
        return tmp == 0 ? cnt : ++cnt;
    }

    static void bs(){
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = isMatched(mid);
            if(cnt <= M)
                right = mid - 1;
            else
                left = mid + 1;
        }
    }

}