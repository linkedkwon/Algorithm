package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P2798 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for(int i = 0; i < N - 2; i++){
            if(cards[i] > M)
                continue;
            for(int j = i + 1; j < N - 1; j++){
                if(cards[i] + cards[j] > M)
                    continue;
                for(int k = j + 1; k < N; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum > M)
                        continue;
                    max = Math.max(sum, max);
                }
            }
        }

        System.out.println(max);
        br.close();
    }

}