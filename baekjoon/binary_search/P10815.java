package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10815 {

    static int N;
    static int[] card;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(card);
        bs();
        System.out.println(sb);
        br.close();
    }

    static void readIn() throws IOException{
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            card[i] = Integer.parseInt(st.nextToken());
    }

    static void bs() throws IOException{
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            boolean hasNumber = false;
            int num =  Integer.parseInt(st.nextToken());
            int left = 0, right = N - 1, mid = 0;
            while(left <= right){
                mid = (left + right) / 2;

                if(card[mid] < num){
                    left = mid + 1;
                }else if(card[mid] == num){
                    hasNumber = true;
                    break;
                }else {
                    right = mid - 1;
                }
            }
            sb.append(hasNumber ? '1' : '0').append(' ');
        }
    }

}