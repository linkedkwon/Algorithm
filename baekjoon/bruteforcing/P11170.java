package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11170 {

    static int N;
    static int[][] nm;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        loop();
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nm = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            nm[i][0] = Integer.parseInt(st.nextToken());
            nm[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static void loop(){
        for(int i = 0; i < N; i++){
            int cnt = nm[i][0] == 0 ? 1 : 0;

            for(int j = nm[i][0]; j <= nm[i][1]; j++){
                int tmp = j;
                while(tmp > 0){
                    if(tmp % 10 == 0)
                        cnt++;
                    tmp /= 10;
                }
            }
            sb.append(cnt).append('\n');
        }
    }

}