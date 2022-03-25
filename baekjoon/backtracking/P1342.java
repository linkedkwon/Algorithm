package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1342 {

    static int CNT;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        readIn();
        dfs(0, ' ');
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        visited = new boolean[arr.length];
        br.close();
    }

    static void dfs(int depth, char c){
        if(depth == arr.length) {
            CNT++;
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(c == arr[i] || visited[i])
                continue;
            visited[i] = true;
            dfs(depth + 1, arr[i]);
            visited[i] = false;
        }
    }

    static int getFactorial(int num){
        int multi = 1;
        for(int i = num; i > 1; i--)
            multi *= i;
        return multi;
    }

    static void writeOut(){
        int[] alpha = new int[26];
        for(int i = 0; i < arr.length; i++)
            alpha[arr[i] - 'a']++;

        for(int i = 0; i < 26; i++){
            if(alpha[i] > 1)
                CNT /= getFactorial(alpha[i]);
        }
        System.out.println(CNT);
    }

}