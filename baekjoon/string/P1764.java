package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class P1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashSet<String> table = new HashSet<>();
        for(int i = 0; i < N; i++)
            table.add(br.readLine());

        ArrayList<String> arr = new ArrayList<>();
        for(int j = 0; j < M; j++){
            String str = br.readLine();
            if(table.contains(str))
                arr.add(str);
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arr.size() + "\n");
        for(String obj : arr)
            sb.append(obj + "\n");

        System.out.println(sb);
        br.close();
    }
}