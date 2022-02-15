package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {

    static int N, CNT;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        tp();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void tp(){
        for(int i = 0; i < N; i++){
            int dx = 0, dy = N - 1;
            int num = arr[i];

            while(dx < dy){
                if(i == dx)
                    dx++;
                else if(i == dy)
                    dy--;
                else{
                    int sum = arr[dx] + arr[dy];
                    if(num > sum)
                        dx++;
                    else if(num == sum) {
                        CNT++;
                        break;
                    }else
                        dy--;
                }
            }
        }
    }

}