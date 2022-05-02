package baekjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2458 {

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
                arr[i][j] = i == j ? 0 : 1000;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;
            arr[y][x] = 1;
        }
        br.close();
    }

    static void floydWarshall(){
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1)
                        arr[i][j] = 1;
                }
            }
        }
    }

    static void postProcess(){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            boolean hasKnown = true;
            for(int j = 0; j < N; j++){
                if(i == j) continue;

                if(arr[i][j] != 1 && arr[j][i] != 1){
                    hasKnown = false;
                    break;
                }
            }
            if(hasKnown) cnt++;
        }
        System.out.println(cnt);
    }

}