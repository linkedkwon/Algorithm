package baekjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1389 {

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        preProcess();
        floydWarshall();
        postProcess();
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                arr[i][j] = i == j ? 0 : 101;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = arr[y][x] = 1;
        }
        br.close();
    }

    static void floydWarshall(){
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }

    static void postProcess(){
        int min = Integer.MAX_VALUE, dx = 0;
        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < N; j++)
                sum += arr[i][j];
            if(sum < min){
                dx = i + 1;
                min = sum;
            }
        }
        System.out.println(dx);
    }

}