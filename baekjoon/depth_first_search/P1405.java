package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1405 {

    static int N;
    static double answer;
    static int[] x = {0, 0, 1, -1}, y = {1, -1, 0, 0};
    static double[] percent = new double[4];
    static boolean[][] visited = new boolean[29][29];

    public static void main(String[] args) throws IOException{
        readIn();
        visited[14][14] = true;
        dfs(0, 14, 14, 1);
        System.out.println(answer);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 4; i++)
            percent[i] = Double.parseDouble(st.nextToken()) * 0.01;
        br.close();
    }

    static void dfs(int depth, int i, int j, double result){
        if(depth == N) {
            answer += result;
            return;
        }

        for(int d = 0; d < 4; d++){
            int dx = i + x[d], dy = j + y[d];
            if(!visited[dx][dy]){
                visited[dx][dy] = true;
                dfs(depth + 1, dx, dy, result * percent[d]);
                visited[dx][dy] = false;
            }
        }
    }

}