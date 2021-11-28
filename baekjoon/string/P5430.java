package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class P5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String P = br.readLine();
            Deque<String> deq = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());

            String[] str = br.readLine().replaceAll("\\[", "")
                    .replaceAll("\\]", "")
                    .split(",");

            for (int j = 0; j < N; j++)
                deq.add(str[j]);

            int reversed = -1, eState = 0;
            for (int j = 0; j < P.length(); j++) {
                if (P.charAt(j) == 'R') {
                    reversed *= -1;
                }
                else {
                    if(deq.isEmpty()){
                        eState = 1;
                        break;
                    }
                    if (reversed == -1)
                        deq.pollFirst();
                    else
                        deq.pollLast();
                }
            }

            if (eState == 1) {
                sb.append("error\n");
            } else {
                sb.append("[");
                int size = deq.size();
                for (int j = 0; j < size; j++) {
                    sb.append(reversed == -1 ? deq.pollFirst(): deq.pollLast());
                    if (j + 1 != size)
                        sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}