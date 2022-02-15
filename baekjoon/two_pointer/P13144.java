package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13144 {

    static int N;
    static long CNT;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        tp();
        System.out.println(CNT);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void tp(){
        int dy = 0;
        for(int dx = 0; dx < N; dx++){
            while(dy < N){
                if(visited[arr[dy]])
                    break;
                visited[arr[dy++]] = true;
            }
            CNT += dy - dx;
            visited[arr[dx]] = false;
        }
    }

}