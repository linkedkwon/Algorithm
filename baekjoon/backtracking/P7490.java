package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P7490 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            dfs(1, "1");
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int depth, String str){
        if(depth == N){
            if(str.length() == 2 * N - 1 && hasZero(str))
               sb.append(str).append('\n');
            return;
        }

        for(int i = depth + 1; i <= N; i++){
            dfs(i, str + " " + i);
            dfs(i, str + "+" + i);
            dfs(i, str + "-" + i);
        }
    }

    static boolean hasZero(String str){
        str = str.replaceAll(" ", "");
        int sum = 0, tmp = 1, len = str.length();
        boolean isPositive = true;
        for(int i = 1; i < len; i++){
            char c = str.charAt(i);
            if(c == '+'){
                sum = isPositive ? sum + tmp : sum - tmp;
                isPositive =  true;
                tmp = 0;
            }else if(c == '-'){
                sum = isPositive ? sum + tmp : sum - tmp;
                isPositive = false;
                tmp = 0;
            }else{
                tmp = tmp * 10  + (c - '0');
            }
        }

        sum = isPositive ? sum + tmp : sum - tmp;
        return sum == 0 ? true : false;
    }

}