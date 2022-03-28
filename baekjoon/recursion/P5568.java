package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P5568 {

    static int N, K;
    static int[] cards, used;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(0);
        System.out.println(set.size());
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); K = Integer.parseInt(br.readLine());
        cards = new int[N]; visited = new boolean[N]; used = new int[K];
        for(int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(br.readLine());
        br.close();
    }

    static void dfs(int depth){
        if(depth == K){
            int num = 0;
            for(int i = 0; i < K; i++){
                int selected = used[i];
                num *= selected >= 10 ? 100 : 10;
                num += selected;
            }
            set.add(num);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                used[depth] = cards[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

}