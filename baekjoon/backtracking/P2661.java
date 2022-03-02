package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2661 {

    static int N;

    public static void main(String[] args) throws IOException{
        readIn();
        dfs("");
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    static boolean isMatched(String str){
        for(int i = 1; i <= str.length() / 2; i++){
            String left = str.substring(str.length() - 2 * i, str.length() - i);
            String right = str.substring(str.length() - i, str.length());
            if(left.equals(right))
                return false;
        }
        return true;
    }

    static void dfs(String str){
        if(str.length() == N) {
            System.out.println(str);
            System.exit(0);
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(isMatched(str + i))
                dfs(str + i);
        }
    }

}