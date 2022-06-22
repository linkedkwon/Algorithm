package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22864 {

    static int a, b, c, m, process = 0;

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
        System.out.println(process);
    }

    static void preProcess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void process() {
        int tired = 0;
        for(int i = 0; i < 24; i++) {
            if(tired + a > m) {
                tired = tired - c < 0 ? 0 : tired - c;
                continue;
            }
            process += b;
            tired += a;
        }
    }

}