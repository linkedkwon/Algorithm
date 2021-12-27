package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P3015 {

    public static class Height{

        public int h;
        public long cnt;

        public Height(int h, long cnt){
            this.h = h;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Height> stack = new Stack<>();

        long answer = 0;
        for(int i = 0; i < N; i++){
            int h = Integer.parseInt(br.readLine());
            Height obj = new Height(h, 1);

            while(!stack.isEmpty()){
                if(stack.peek().h <= h){
                    Height pop = stack.pop();
                    answer += pop.cnt;
                    if(pop.h == h)
                        obj.cnt += pop.cnt;
                }
                else {
                    answer++;
                    break;
                }
            }
            stack.push(obj);
        }
        System.out.println(answer);
        br.close();
    }

}