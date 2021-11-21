package baekjoon.string;

import java.io.*;

public class P1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        int[] arr = new int[10];

        for(int i = 0; i < N.length(); i++)
            arr[Integer.parseInt(String.valueOf(N.charAt(i)))]++;

        for(int i = 9; i >= 0; i--){
            for(int j = 0; j < arr[i]; j++)
                bw.write(Integer.toString(i));
        }
        br.close();
        bw.close();
    }
}