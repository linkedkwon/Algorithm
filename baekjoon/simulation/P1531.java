package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1531 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] paper = new int[101][101];

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        for(int k = 0; k < n; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
                x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++)
                    paper[i][j]++;
            }
        }

        int cnt = 0;
        for(int i = 0; i <= 100; i++){
            for(int j = 0; j <= 100; j++){
                if(paper[i][j] > m)
                    cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

}