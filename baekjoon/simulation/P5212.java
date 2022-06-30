package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5212 {

    static int r, c;
    static char[][] preMap;
    static char[][] postMap;

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        postProcess();
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
        preMap = new char[r][c]; postMap = new char[r][c];

        for(int i = 0; i < r; i++){
            String str = br.readLine();
            preMap[i] = str.toCharArray();
            postMap[i] = str.toCharArray();
        }
        br.close();
    }

    static void process(){
        int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(preMap[i][j] == '.')
                    continue;
                int cnt = 0;
                for(int d = 0; d < 4; d++){
                    int dx = x[d] + i, dy = y[d] + j;
                    if(dx < 0 || dy < 0 || dx >= r || dy >= c || preMap[dx][dy] == '.')
                        cnt++;
                        continue;
                }
                if(cnt > 2)
                    postMap[i][j] = '.';
            }
        }
    }

    static void postProcess(){
        int minX = r, minY = c, maxX = 0, maxY = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(postMap[i][j] == 'X'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = minX; i <= maxX; i++){
            for(int j = minY; j <= maxY; j++)
                sb.append(postMap[i][j]);
            sb.append('\n');
        }

        System.out.println(sb);
    }

}