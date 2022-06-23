package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1333 {

    static int n, l, d;
    static boolean[] t = new boolean[20 * 180 + 20 * 5];

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
    }

    static void preProcess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); l = Integer.parseInt(st.nextToken()); d = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void process() {
        int sec = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < l; j++)
                t[j + sec] = true;
            sec += l + 5;
        }

        int len = n * l + (n - 1) * 5, dx = d, i = 1;
        while(t[dx] && dx < len){
            dx = d * ++i;
        }

        System.out.println(dx);
    }

}