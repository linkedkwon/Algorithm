package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1547 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = {1, 2, 3};
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()),
                dx = 0, dy = 0;

            for(int j = 0; j < 3; j++){
                if(arr[j] == x) dx = j;
                if(arr[j] == y) dy = j;
            }
            arr[dx] = y;
            arr[dy] = x;
        }
        System.out.println(arr[0]);
        br.close();
    }

}