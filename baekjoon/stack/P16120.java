package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P16120 {

    static String str;
    static char[] frame = {'P', 'A', 'P', 'P'};
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        br.close();
    }

    static void process(){
        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));

            if(stack.size() > 3) {
                int dx = 0, cnt = 0;
                Stack<Character> tmp = new Stack<>();
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    tmp.push(c);
                    if(frame[dx++] == c) cnt++;
                    else break;

                    if(cnt == 4) {
                        tmp.clear();
                        stack.push('P');
                        dx = cnt = 0;
                    }
                }

                while(!tmp.isEmpty()){
                    stack.push(tmp.pop());
                }
            }
        }
    }

    static void writeOut(){
        if(stack.size() == 1 && stack.peek() != 'A') System.out.println("PPAP");
        else System.out.println("NP");
    }

}