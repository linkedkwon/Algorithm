package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P2667 {

    private static int N;
    private static char[][] map;
    private static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N + 1][N + 1];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++)
                map[i + 1][j + 1] = str.charAt(j);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] == '1')
                    arr.add(dfs(i, j, 1));
            }
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arr.size() + "\n");
        for(int i : arr)
            sb.append(i + "\n");

        System.out.println(sb);
        br.close();
    }

    public static int dfs(int i, int j, int cnt){
        map[i][j] = '0';

        for(int n = 0; n < 4; n++){
            int x = i + dx[n], y = j + dy[n];

            if(x < 1 || x > N || y < 1 || y > N)
                continue;
            if(map[x][y] == '1')
                cnt += dfs(x, y, 1);
        }

        return cnt;
    }
}