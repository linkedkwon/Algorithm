package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2841 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[6];
        for(int i = 0; i < 6; i++)
            stacks[i] = new Stack<>();

        int cnt = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1, p = Integer.parseInt(st.nextToken());

            boolean hasPressed = false;
            while(!stacks[l].isEmpty()){
                if(stacks[l].peek() < p){
                    break;
                }
                else if(stacks[l].peek() == p){
                    hasPressed = true;
                    break;
                }
                else{
                    stacks[l].pop();
                    cnt++;
                }
            }

            if(!hasPressed) {
                stacks[l].push(p);
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}