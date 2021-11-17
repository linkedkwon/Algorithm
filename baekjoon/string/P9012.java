package baekjoon.string;

import java.io.*;

public class P9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int top = 0;
            for(int j = 0; j < str.length(); j++){
                top += str.charAt(j) == '(' ? 1 : -1;
                if(top < 0)
                    break;
            }
            bw.write(top == 0 ? "YES\n" : "NO\n");
        }
        br.close();
        bw.close();
    }
}