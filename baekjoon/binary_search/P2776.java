package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2776 {

    static int N, M;
    static int[] arr, num;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            readIn();
            bs();
        }
        System.out.println(sb);
        br.close();
    }

    static void readIn() throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        num = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            num[i] = Integer.parseInt(st.nextToken());
    }

    static void bs(){
        Arrays.sort(arr);
        for(int i = 0; i < M; i++) {
            int left = 0, right = N - 1, mid = 0;
            boolean hasNumber = false;

            while (left <= right) {
                mid = (left + right) / 2;
                if (arr[mid] == num[i]){
                    hasNumber = true;
                    break;
                }else if(arr[mid] < num[i])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            sb.append(hasNumber ? "1" : "0").append('\n');
        }
    }

}