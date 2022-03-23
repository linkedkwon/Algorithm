package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15686 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, MIN = Integer.MAX_VALUE;
    static boolean[] visited;
    static ArrayList<Pair> home = new ArrayList<>();
    static ArrayList<Pair> shop = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(0, 0);
        System.out.println(MIN);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1)
                    home.add(new Pair(i, j));
                else if(num == 2)
                    shop.add(new Pair(i, j));
            }
        }

        visited = new boolean[shop.size()];
        br.close();
    }

    static void dfs(int depth, int dx){
        if(depth == M){
            int sum = 0;
            for(int i = 0; i < home.size(); i++){
                int dist = Integer.MAX_VALUE;
                for(int j = 0; j < visited.length; j++){
                    if(visited[j])
                        dist = Math.min(dist, Math.abs(home.get(i).x - shop.get(j).x) + Math.abs(home.get(i).y - shop.get(j).y));
                }
                sum += dist;
            }
            MIN = Math.min(MIN, sum);
            return;
        }

        for(int i = dx; i < shop.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

}