package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], 0);
        }

        Object[] keySet = map.keySet().toArray();
        Arrays.sort(keySet);

        int dx = 0;
        for(Object key : keySet)
            map.put((Integer)key, dx++);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(map.get(arr[i])).append(' ');

        System.out.println(sb);
        br.close();
    }

}