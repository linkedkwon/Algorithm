package baekjoon.string;

import java.io.*;

public class P11721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        bw.write(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            if(i % 10 == 0)
                bw.write("\n");
            bw.write(str.charAt(i));
        }

        br.close();
        bw.close();
    }
}