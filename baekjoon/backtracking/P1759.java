package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {

    static int L, C;
    static char[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++)
            arr[i] = st.nextToken().charAt(0);

        br.close();
    }

    static void appendCharacter(){
        int v = 0, c = 0;
        for(int i = 0; i < C; i++){
            if(visited[i]){
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') v++;
                else c++;
            }
        }
        if(v > 0 && c > 1){
            for(int i = 0; i < C; i++){
                if(visited[i])
                    sb.append(arr[i]);
            }
            sb.append('\n');
        }
    }

    static void dfs(int depth, int dx){
        if(depth == L){
            appendCharacter();
            return;
        }

        for(int i = dx; i < C; i++){
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}