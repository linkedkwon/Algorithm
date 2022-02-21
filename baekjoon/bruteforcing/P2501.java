package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2501 {

    static int N, K;
    static int[] div;

    public static void main(String[] args) throws IOException{
        readIn();
        bruteforce();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        div = new int[N + 1];
        br.close();
    }

    static void bruteforce(){
        int dx = 1;
        for(int i = 1; i <= N; i++){
            if(N / i != 0 && N % i == 0)
                div[dx++] = i;
        }

        System.out.println(div[K]);
    }

}