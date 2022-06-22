package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4084 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String read = "", end = "0 0 0 0";
        while(!(read = br.readLine()).equals(end)){
            StringTokenizer st = new StringTokenizer(read);
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
                c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()),
                cnt = 0;

            while(true){
                if(a == b && b == c && c == d)
                    break;
                int tmp = a;
                a = Math.abs(a - b);
                b = Math.abs(b - c);
                c = Math.abs(c - d);
                d = Math.abs(d - tmp);
                cnt++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}