package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14503 {

    static int N, M, R, C, D, CNT;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        if(arr[R][C] == 0){
            arr[R][C] = 2;
            CNT++;
        }
        process();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); D = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static void process() {
        while (true) {
            int dz = D;
            boolean hasMoved = false;
            for (int k = 0; k < 4; k++) {
                int dx = R, dy = C;
                if (dz == 0) { dy -= 1; dz = 3;
                } else if (dz == 1) { dx -= 1; dz = 0;
                } else if (dz == 2) { dy += 1; dz = 1;
                } else { dx += 1; dz = 2;}

                if(dx < 0 || dy < 0 || dx >= N || dy >= M || arr[dx][dy] >= 1)
                    continue;
                hasMoved = true;
                arr[dx][dy] = 2;
                R = dx; C = dy; D = dz;
                CNT++;
                break;
            }

            if(hasMoved)
                continue;

            if(D == 0) R += 1;
            else if(D == 1) C -= 1;
            else if(D == 2) R -= 1;
            else C += 1;

            if(R < 0 || C < 0 || R > N || C > M || arr[R][C] == 1)
                break;
        }
    }

}