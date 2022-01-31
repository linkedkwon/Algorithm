package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1264 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while(!(str = br.readLine()).equals("#")){
            int cnt = 0;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                   c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U')
                    cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
