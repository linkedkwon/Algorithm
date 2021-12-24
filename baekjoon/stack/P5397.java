package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P5397 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            String l = br.readLine();
            Stack<Character> keys = new Stack<>(),
                            stack = new Stack<>();

            for(int i = 0; i < l.length(); i++){
                char c = l.charAt(i);
                if(c == '<'){
                    if(!keys.isEmpty())
                        stack.push(keys.pop());
                }
                else if(c == '>'){
                    if(!stack.isEmpty())
                        keys.push(stack.pop());
                }
                else if(c == '-'){
                    if(!keys.isEmpty())
                        keys.pop();
                }
                else{
                    keys.push(c);
                }
            }

            for(Character c : keys)
                sb.append(c);

            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}