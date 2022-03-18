package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13565 {

    static int N, M;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static char[][] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        System.out.println("NO");
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for(int i = 0; i < N; i++)
            arr[i] = br.readLine().toCharArray();

        br.close();
    }

    static void process(){
        for(int i = 0 ; i < M; i++)
            if(arr[0][i] == '0')
                dfs(0, i);
    }

    static void dfs(int i, int j){
        if(i == N - 1){
            System.out.println("YES");
            System.exit(0);
        }
        arr[i][j] = '1';
        for(int d = 0; d < 4; d++){
            int dx = i + x[d], dy = j + y[d];
            if(dx < 0 || dy < 0 || dy >= M || arr[dx][dy] == '1')
                continue;
            dfs(dx, dy);
        }
    }

}