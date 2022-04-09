package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2490 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for(int j = 0; j < 4; j++) {
                if(Integer.parseInt(st.nextToken()) == 0)
                    cnt++;
            }

            char c = ' ';
            switch (cnt){
                case 0: c = 'E'; break;
                case 1: c = 'A'; break;
                case 2: c = 'B'; break;
                case 3: c = 'C'; break;
                case 4: c = 'D'; break;
            }
            sb.append(c).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}