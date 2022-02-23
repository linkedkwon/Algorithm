package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2529 {

    static int K;
    static long MAX, MIN = Long.MAX_VALUE;
    static char[] sign;
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(0, new int[K + 1]);
        System.out.println(Long.toString(MAX).length() == K + 1 ? MAX : "0" + MAX);
        System.out.println(Long.toString(MIN).length() == K + 1 ? MIN : "0" + MIN);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        sign = new char[K + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= K; i++)
            sign[i] = st.nextToken().charAt(0);

        br.close();
    }

    static void dfs(int depth, int[] tmp){
        if(depth == K + 1){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <= K; i++)
                sb.append(tmp[i]);
            MAX = Math.max(MAX, Long.parseLong(sb.toString()));
            MIN = Math.min(MIN, Long.parseLong(sb.toString()));
            return;
        }

        for(int i = 0; i < 10; i++){
            if(!visited[i]){
                if(depth > 0){
                    char c = sign[depth];
                    if(c == '<' && tmp[depth - 1] >= i)
                        continue;
                    if(c == '>' && tmp[depth - 1] <= i)
                        continue;
                }
                visited[i] = true;
                tmp[depth] = i;
                dfs(depth + 1, tmp);
                visited[i] = false;
            }
        }
    }

}