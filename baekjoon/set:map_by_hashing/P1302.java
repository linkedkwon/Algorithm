package baekjoon.set_map_by_hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P1302 {

    static int N, MAX;
    static ArrayList<String> arr = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        readIn();
        process();
        Collections.sort(arr);
        System.out.println(arr.get(0));
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (map.containsKey(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
        br.close();
    }

    static void process(){
        for(String key : map.keySet())
            MAX = Math.max(MAX, map.get(key));

        for(String key : map.keySet()){
            if(map.get(key) == MAX)
                arr.add(key);
        }
    }

}