package baekjoon.set_map_by_hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P14425 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashSet<String> key = new HashSet<>();
        for(int i = 0; i < N; i++)
            key.add(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < M; i++){
            String read = br.readLine();
            map.put(read, map.containsKey(read) ? map.get(read) + 1 : 1);
        }

        int cnt = 0;
        for(String e : key){
            if(map.containsKey(e))
                cnt += map.get(e);
        }

        System.out.println(cnt);
        br.close();
    }

}