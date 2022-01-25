package baekjoon.depth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import java.util.StringTokenizer;

public class P2583 {

    private static int M, N, cnt = 0;
    private static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static StringBuilder sb;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException{
        readIn();
        searchNoFilled();
        appendData();
        System.out.println(sb);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];

        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
                x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

            fillSquareToArray(x1, y1, x2, y2);
        }

        list = new ArrayList<>();
        br.close();
    }

    public static void fillSquareToArray(int x1, int y1, int x2, int y2){
        for(int i = y1; i < y2; i++){
            for(int j = x1; j < x2; j++)
                visited[i][j] = true;
        }
    }

    public static int dfs(int i, int j){
        visited[i][j] = true;

        int area = 1;
        for(int d = 0; d < 4; d++){
            int dx = i + x[d], dy = j + y[d];
            if(dx < 0 || dy < 0 || dx >= M || dy >= N)
                continue;
            if(!visited[dx][dy])
                area += dfs(dx, dy);
        }

        return area;
    }

    public static void searchNoFilled(){
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    list.add(dfs(i, j));
                    cnt++;
                }
            }
        }
    }

    public static void appendData(){
        sb.append(cnt).append("\n");
        Collections.sort(list);
        for(int o : list)
            sb.append(o + " ");
    }

}