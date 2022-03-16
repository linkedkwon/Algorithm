package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3187 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int R, C;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] arr;
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j] && arr[i][j] != '#'){
                    visited[i][j] = true;
                    queue.offer(new Pair(i, j));
                    bfs();
                }
            }
        }
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        arr = new char[R][C]; visited = new boolean[R][C];
        for(int i = 0; i < R; i++)
            arr[i] = br.readLine().toCharArray();
        br.close();
    }

    static void bfs(){
        ArrayList<Pair> sheep = new ArrayList<>(), wolf = new ArrayList<>();
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            char c = arr[p.x][p.y];
            if(c == 'v')
                wolf.add(new Pair(p.x, p.y));
            else if(c == 'k')
                sheep.add(new Pair(p.x, p.y));

            for(int d = 0; d < 4; d++){
                int dx = p.x + x[d], dy = p.y + y[d];
                if(dx < 0 || dy < 0 || dx >= R || dy >= C || visited[dx][dy] || arr[dx][dy] == '#')
                    continue;
                visited[dx][dy] = true;
                queue.offer(new Pair(dx, dy));
            }
        }

        if(sheep.size() > wolf.size()){
            for(Pair p : wolf)
                arr[p.x][p.y] = '.';
        }else{
            for(Pair p : sheep)
                arr[p.x][p.y] = '.';
        }
    }

    static void writeOut(){
        int sheep = 0, wolf = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                char c = arr[i][j];
                if(c == 'v')
                    wolf++;
                else if(c == 'k')
                    sheep++;
            }
        }
        System.out.println(sheep + " " + wolf);
    }

}