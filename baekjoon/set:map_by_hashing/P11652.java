package baekjoon.set_map_by_hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P11652 {

    static int N, MAX = 1;
    static long MIN = Long.MAX_VALUE;
    static HashMap<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        readIn();
        loop();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            long key = Long.parseLong(br.readLine());
            int val = 1;
            if(map.containsKey(key))
                val += map.get(key);
            map.put(key, val);

            MAX = Math.max(MAX, val);
        }
        br.close();
    }

    static void loop(){
        for(long key : map.keySet()){
            if(map.get(key) == MAX)
                MIN = Math.min(MIN, key);
        }

        System.out.println(MIN);
    }

}