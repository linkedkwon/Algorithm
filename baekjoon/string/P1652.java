package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1652 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] condo = new char[N][N];
        for(int i = 0; i < N; i++)
            condo[i] = br.readLine().toCharArray();

        int width = 0, height = 0;
        for(int i = 0; i < N; i++){

            int sequenceCnt = 0;
            for(int j = 0; j < N; j++){
                if(condo[i][j] == '.')
                    sequenceCnt++;
                else{
                    if(sequenceCnt >= 2)
                        width++;
                    sequenceCnt = 0;
                }
            }

            if(sequenceCnt >= 2)
                width++;

            sequenceCnt = 0;
            for(int j = 0; j < N; j++){
                if(condo[j][i] == '.'){
                    sequenceCnt++;
                }
                else{
                    if(sequenceCnt >= 2)
                        height++;
                    sequenceCnt = 0;
                }
            }

            if(sequenceCnt >= 2)
                height++;

        }

        System.out.println(width + " " + height);
        br.close();
    }
}