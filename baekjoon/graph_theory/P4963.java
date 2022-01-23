package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4963 {

    private static int w, h;
    private static int[][] map;
    private static int[] x = {-1, 1, 0, 0, -1, 1, 1, -1}, y = {0, 0, -1, 1, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while(!((str = br.readLine()).charAt(0) == '0')) {
            StringTokenizer st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());

            map = new int[h + 1][w + 1];
            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int i, int j){
        for(int k = 0; k < 8; k++){
            int dx = x[k] + i, dy = y[k] + j;

            if(dx < 1 || dy < 1 || dx > h || dy > w)
                continue;
            if(map[dx][dy] == 1) {
                map[dx][dy] = 0;
                dfs(dx, dy);
            }
        }
    }

}