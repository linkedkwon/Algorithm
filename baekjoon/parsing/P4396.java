package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4396 {

    static int n;
    static char[][] pre, post, arr;

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pre = new char[n][n]; post = new char[n][n]; arr = new char[n][n];

        for(int i = 0; i < n; i++)
            pre[i] = br.readLine().toCharArray();
        for(int i = 0; i < n; i++)
            post[i] = br.readLine().toCharArray();

        br.close();
    }

    static void process(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                arr[i][j] = post[i][j];
        }

        int[] x = {-1, 1, 0, 0, -1, 1, -1, 1}, y = {0, 0, -1, 1, -1, -1, 1, 1};
        boolean hasStepMine = false;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(post[i][j] == 'x'){
                    if(pre[i][j] == '*'){
                        hasStepMine = true;
                        continue;
                    }

                    int cnt = 0;
                    for(int k = 0; k < 8; k++){
                        int dx = i + x[k], dy = j + y[k];
                        if(dx < 0 || dy < 0 || dx >= n || dy >= n)
                            continue;
                        if(pre[dx][dy] == '*')
                            cnt++;
                    }
                    arr[i][j] = (char)(cnt + '0');
                }
            }
        }

        if(hasStepMine){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(pre[i][j] == '*')
                        arr[i][j] = '*';
                }
            }
        }
    }

    public static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                sb.append(arr[i][j]);
            sb.append('\n');
        }

        System.out.println(sb);
    }

}