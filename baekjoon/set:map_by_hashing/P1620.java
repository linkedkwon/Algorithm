package baekjoon.set_map_by_hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1620 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashMap<String, String> guide = new HashMap<>();
        for(int i = 1; i < N + 1; i++){
            String value = br.readLine();
            String key = Integer.toString(i);
            guide.put(value, key);
            guide.put(key, value);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++)
            sb.append(guide.get(br.readLine()) + "\n");

        System.out.println(sb);
        br.close();
    }
}