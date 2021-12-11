package baekjoon.set_map_by_hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Optional;
import java.util.StringTokenizer;

//hashing
public class P10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> card = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int key = Integer.parseInt(st.nextToken());
            card.put(key, Optional.ofNullable(card.get(key))
                    .orElseGet(() -> {return 0;}) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            sb.append(Optional.ofNullable(card.get(Integer.parseInt(st.nextToken())))
                    .orElseGet(() -> {return 0;}) + " ");
        }

        System.out.println(sb);
        br.close();
    }
}