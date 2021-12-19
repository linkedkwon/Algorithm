package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[0] < num)
                    stack.pop();
                else {
                    sb.append(stack.peek()[1] + " ");
                    break;
                }
            }

            if(stack.isEmpty())
                sb.append("0 ");
            stack.add(new int[]{num, i});
        }

        System.out.println(sb);
        br.close();
    }
}