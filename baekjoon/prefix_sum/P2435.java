package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2435 {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        System.out.println(getPrefixSum());
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    static int getPrefixSum(){
        int sum = 0;
        for(int i = 0; i < K; i++)
            sum += arr[i];

        int dx = 0, max = sum;
        for(int i = K; i < N; i++) {
            sum = sum + arr[i] - arr[dx++];
            max = Math.max(max, sum);
        }
        return max;
    }

}