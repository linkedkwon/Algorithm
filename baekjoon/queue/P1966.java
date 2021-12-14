package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966 {

    private static int T, N, M;
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            inputStream(br.readLine(), br.readLine());
            sb.append(getOrderByPriority() + "\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void inputStream(String read1, String read2){
        StringTokenizer st = new StringTokenizer(read1);
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();

        st = new StringTokenizer(read2);
        for(int i = 0; i < N; i++)
            queue.add(Integer.parseInt(st.nextToken()));
    }

    public static int getOrderByPriority(){
        int cnt = 0;
        while(!queue.isEmpty()){
            int max = getMaxValue(), order = queue.poll();
            if(order == max) {
                cnt++;
                if(M == 0)
                    break;
                else
                    M--;
            }
            else {
                queue.add(order);
                M = M == 0 ? queue.size() - 1 : --M;
            }
        }

        return cnt;
    }

    public static int getMaxValue(){
        int max = 0;
        for(int o : queue)
            max = Math.max(max, o);
        return max;
    }
}