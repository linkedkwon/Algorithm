package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17952 {

    static class Pair{
        int s, m;

        public Pair(int s, int m) {
            this.s = s;
            this.m = m;
        }
    }
    static int ANS = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 1){
                int s = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()) - 1;
                if(m == 0) ANS += s;
                else stack.push(new Pair(s, m));
            }else{
                if(stack.isEmpty())
                    continue;
                Pair p = stack.pop();
                p.m--;

                if(p.m == 0) ANS += p.s;
                else stack.push(new Pair(p.s, p.m));
            }
        }
        System.out.println(ANS);
        br.close();
    }

}