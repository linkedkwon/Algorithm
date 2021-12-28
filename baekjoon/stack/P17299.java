package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17299 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        int[] dx = new int[N], answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[n]++;
            dx[i] = n;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && arr[dx[i]] > arr[dx[stack.peek()]]){
                answer[stack.pop()] = dx[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(answer[i] == 0 ? -1 : answer[i]).append(" ");

        System.out.println(sb);
        br.close();
    }
}