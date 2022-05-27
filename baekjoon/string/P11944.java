package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11944 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String N = st.nextToken();
        int M = Integer.parseInt(st.nextToken()), len = N.length();
        if(len * Integer.parseInt(N) < M){
            int size = Integer.parseInt(N);
            for(int i = 0; i < size; i++)
                sb.append(N);
        }else {
            int size = M / len;
            for (int i = 0; i < size; i++)
                sb.append(N);
            if (M % len != 0)
                sb.append(N.substring(0, M % len));
        }

        System.out.println(sb);
        br.close();
    }

}