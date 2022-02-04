package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P1525 {

    private static Queue<String> queue = new LinkedList<>();
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        readIn();
        System.out.println(map.containsKey("123456780") ? "0" : bfs());
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; i++)
            sb.append(br.readLine().replace(" ", ""));

        map.put(sb.toString(), 0);
        queue.offer(sb.toString());

        br.close();
    }

    public static int bfs(){
        int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            String str = queue.poll();
            int idx = str.indexOf("0");
            int pX = idx / 3, pY = idx % 3;

            for(int d = 0; d < 4; d++){
                int dx = pX + x[d], dy = pY + y[d];
                if(dx < 0 || dy < 0 || dx >= 3 || dy >= 3)
                    continue;

                int tmp = dx * 3 + dy;
                StringBuilder sb = new StringBuilder(str);
                char c = sb.charAt(tmp);
                sb.setCharAt(tmp, '0');
                sb.setCharAt(idx, c);

                if(sb.toString().equals("123456780"))
                    return map.get(str) + 1;

                if(!map.containsKey(sb.toString())){
                    queue.offer(sb.toString());
                    map.put(sb.toString(), map.get(str) + 1);
                }
            }
        }
        return -1;
    }

}