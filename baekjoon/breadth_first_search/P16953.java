package baekjoon.breadth_first_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16953 {

    public static class Num{
        long val;
        int cnt;

        public Num(long val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    private static long A, B;
    private static Queue<Num> queue;

    public static void main(String[] args) throws IOException{
        readIn();
        System.out.println(bfs());
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken()); B = Long.parseLong(st.nextToken());

        queue = new LinkedList<>();
        queue.offer(new Num(A, 1));
        br.close();
    }

    public static long bfs(){
        long answer = -1;
        while(!queue.isEmpty()){
            Num obj = queue.poll();
            if(obj.val == B){
                answer = obj.cnt;
                break;
            }
            long dx = obj.val * 2, dy = obj.val * 10 + 1;
            if(dx <= B) queue.offer(new Num(dx, obj.cnt + 1));
            if(dy <= B) queue.offer(new Num(dy, obj.cnt + 1));
        }

        return answer;
    }
}
