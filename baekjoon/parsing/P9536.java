package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9536 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            String[] words = br.readLine().split(" ");
            boolean[] used = new boolean[words.length];

            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                if(st.countTokens() > 3)
                    break;
                st.nextToken(); st.nextToken();
                String word = st.nextToken();
                for(int i = 0; i < words.length; i++){
                    if(word.equals(words[i]))
                        used[i] = true;
                }
            }

            for(int i = 0; i < words.length; i++){
                if(!used[i])
                    sb.append(words[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }

}