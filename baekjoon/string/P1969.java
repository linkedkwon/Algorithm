package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1969 {

    static int n, m;
    static String[] arr;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
        postProcess();
    }

    static void preProcess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new String[n];
        ch = new int[m];

        for(int i = 0; i < n; i++)
            arr[i] = br.readLine();

        br.close();
    }

    static void process() {
        for(int i = 0; i < m; i++){
            int[] alpha = new int[26];
            for(int j = 0; j < n; j++)
                alpha[arr[j].charAt(i) - 65]++;

            int max = alpha[0], dx = 0;
            for(int j = 1; j < 26; j++){
                if(max < alpha[j]){
                    max = alpha[j];
                    dx = j;
                }
            }
            ch[i] = dx;
        }
    }

    static void postProcess(){
        StringBuilder sb = new StringBuilder();
        int hd = 0;
        for(int i = 0; i < m; i++){
            char c = (char)(ch[i] + 65);
            for(int j = 0; j < n; j++){
                if(c != arr[j].charAt(i))
                    hd++;
            }
            sb.append(c);
        }

        System.out.println(sb.toString() + '\n' + hd);
    }

}