package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//circular queue
public class P11866 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()) - 1;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i < N + 1; i++)
            arr.add(i);

        StringBuilder sb = new StringBuilder();
        int dx = K;
        while(true){
            if(dx >= arr.size())
                dx %= arr.size();
            sb.append(arr.remove(dx));
            if(arr.isEmpty())
                break;
            sb.append(", ");
            dx += K;
        }

        System.out.println("<" + sb + ">");
        br.close();
    }
}