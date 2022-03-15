package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1406 {

    static String str;
    static Stack<Character> left = new Stack<>(), right = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        preProcess();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if(c == 'L'){
                if(!left.isEmpty())
                    right.push(left.pop());
            }else if(c == 'D'){
                if(!right.isEmpty())
                    left.push(right.pop());
            }else if(c == 'B'){
                if(!left.isEmpty())
                    left.pop();
            }else{
                left.push(st.nextToken().charAt(0));
            }
        }
        writeOut();
        br.close();
    }

    static void preProcess() throws IOException{
        str = br.readLine();
        for(int i = 0; i < str.length(); i++)
            left.push(str.charAt(i));
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(char c : left)
            sb.append(c);
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }

}