package baekjoon.string;

import java.io.*;

public class P11718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while((str = br.readLine())!=null)
            System.out.println(str);

        br.close();
    }
}