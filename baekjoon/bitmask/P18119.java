package baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18119 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] words = new int[N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++)
                words[i] |= (1 << (str.charAt(j) - 97));
        }

        int mask = 0;
        mask |= (~0);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            char inst = st.nextToken().charAt(0), c = st.nextToken().charAt(0);

            switch (inst){
                case '1':
                    mask &= ~(1 << c - 97);
                    break;
                case '2':
                    mask |= (1 << c - 97);
                    break;
            }

            int cnt = 0;
            for(int j = 0; j < N; j++){
                if((mask & words[j]) == words[j])
                    cnt++;
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}