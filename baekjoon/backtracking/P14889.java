package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {

    static int N, MIN = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        backTracking(0, 1);
        System.out.println(MIN);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static void setStatus(){
        int start = 0, link = 0;
        for(int i = 1; i <= N - 1; i++){
            for(int j = i + 1; j <= N; j++){
                if(visited[i] == true && visited[j] == true)
                    start += arr[i][j] + arr[j][i];
                if(visited[i] == false && visited[j] == false)
                    link += arr[i][j] + arr[j][i];
            }
        }
        MIN = Math.min(MIN, Math.abs(start - link));
    }

    static void backTracking(int depth, int dx){
        if(MIN == 0)
            return;
        if(depth == N / 2){
            setStatus();
            return;
        }

        for(int i = dx; i < N; i++){
            visited[i] = true;
            backTracking(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}