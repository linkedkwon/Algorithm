package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {

    static int N, X, CNT;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        getMatchCount();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        X = Integer.parseInt(br.readLine());
        br.close();
    }

    static void getMatchCount(){
        int dx = 0, dy = N - 1;
        while(dx != dy){
            int sum = arr[dx] + arr[dy];
            if(sum < X){
                dx++;
            }else if(sum == X){
                CNT++;
                dy--;
            }else{
                dy--;
            }
        }
    }

}