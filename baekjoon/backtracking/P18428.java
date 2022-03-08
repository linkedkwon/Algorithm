package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P18428 {

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
    static char[][] arr;
    static ArrayList<Pair> teachers = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(0, 0, 0);
        System.out.println("NO");
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken().charAt(0);
                if(arr[i][j] == 'T')
                    teachers.add(new Pair(i, j));
            }
        }
        br.close();
    }

    static boolean isAvoidTeacher(){
        for(Pair p : teachers){
            for(int d = 0; d < 4; d++){
                int dx = p.x, dy = p.y;
                while(true){
                    dx += x[d];
                    dy += y[d];
                    if(dx < 0 || dy < 0 || dx >= N || dy >= N || arr[dx][dy] == 'O')
                        break;
                    if(arr[dx][dy] == 'S')
                        return false;
                }
            }
        }

        return true;
    }

    static void dfs(int depth, int x, int y){
        if(depth == 3){
            if(isAvoidTeacher()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for(int i = x; i < N; i++){
            for(int j = y; j < N; j++){
                if(arr[i][j] == 'X') {
                    arr[i][j] = 'O';
                    dfs(depth + 1, i, j);
                    arr[i][j] = 'X';
                }
            }
            y = 0;
        }
    }

}