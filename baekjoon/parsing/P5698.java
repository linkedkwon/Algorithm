package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5698 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while(!(str = br.readLine()).equals("*")){
            StringTokenizer st = new StringTokenizer(str);
            char c = st.nextToken().charAt(0);
            boolean isTautogram = true;
            while(st.hasMoreTokens()){
                char ch = st.nextToken().charAt(0);
                if(c == ch || Math.abs(c - ch) == 32)
                    continue;
                isTautogram = false;
                break;
            }
            sb.append(isTautogram ? 'Y' : 'N').append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}