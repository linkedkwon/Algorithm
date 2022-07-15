package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1592 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()),
                l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        arr[1] = 1;

        int dx = 1, cnt = 0;
        while(arr[dx] < m){
            if(arr[dx] % 2 == 1) {
                dx = (dx + l);
                if(dx > n)
                    dx %= n;
            }
            else {
                dx -= l;
                if(dx <= 0)
                    dx += n;
            }
            arr[dx]++;
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }

}