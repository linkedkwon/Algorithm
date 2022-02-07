package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {

    static int N, MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;
    static int[] num, operator = new int[4];

    public static void main(String[] args) throws IOException {
        readIn();
        dfs(2, num[1]);
        writeOut();
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());

        br.close();
    }

    public static void writeOut(){
        System.out.println(MAX + "\n" + MIN);
    }

    public static void dfs(int depth, int sum){
        if(depth > N){
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operator[i] == 0)
                continue;

            operator[i]--;
            switch(i){
                case 0 : dfs(depth + 1, sum + num[depth]); break;
                case 1 : dfs(depth + 1, sum - num[depth]); break;
                case 2 : dfs(depth + 1, sum * num[depth]); break;
                case 3 : dfs(depth + 1, sum / num[depth]); break;
            }
            operator[i]++;
        }
    }

}