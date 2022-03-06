package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2210 {

    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static int[][] arr = new int[5][5];
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++)
                dfs(0, i, j, arr[i][j]);
        }
        System.out.println(hashSet.size());
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static void dfs(int depth, int i, int j, int seq){
        if(depth == 5){
            hashSet.add(seq);
            return;
        }

        for(int d = 0; d < 4; d++){
            int dx = i + x[d], dy = j + y[d];
            if(dx < 0 || dy < 0 || dx >= 5 || dy >= 5)
                continue;
            dfs(depth + 1, dx, dy, seq * 10 + arr[dx][dy]);
        }
    }

}