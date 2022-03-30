package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11729 {

    static int N, CNT;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        moveHanoi(N, 1, 2, 3);
        System.out.println(CNT + "\n" + sb);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    static void moveHanoi(int depth, int a, int b, int c){
        if(depth == 1){
            CNT++;
            sb.append(a).append(' ').append(c).append('\n');
            return;
        }

        moveHanoi(depth - 1, a, c, b);
        sb.append(a).append(' ').append(c).append('\n');
        CNT++;
        moveHanoi(depth - 1, b, a, c);
    }

}