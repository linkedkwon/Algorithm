package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11504 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, m, x, y, cnt;
    static ArrayList<Integer> arr;


    public static void main(String[] args) throws IOException {
        process();
        br.close();
    }

    static void preProcess() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        x = Integer.parseInt(br.readLine().replaceAll(" ", ""));
        y = Integer.parseInt(br.readLine().replaceAll(" ", ""));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        cnt = 0;
    }

    static void process() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            preProcess();
            countSubString();
        }

        System.out.println(sb);
    }

    static void countSubString(){
        for(int i = 0; i < n; i++){
            int num = arr.get(0);
            arr.remove(0);
            arr.add(num);

            for(int j = 0; j < m - 1; j++)
                num = num * 10 + arr.get(j);

            if(x <= num && num <= y)
                cnt++;
        }
        sb.append(cnt).append('\n');
    }

}