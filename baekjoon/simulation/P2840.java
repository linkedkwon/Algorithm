package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()),
            k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()), right = Integer.parseInt(st.nextToken());
            if(x == left)
                x = right;
            else if(x == right)
                x = left;
        }

        System.out.println(x);
        br.close();

    }

}