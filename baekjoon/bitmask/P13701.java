package baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class P13701 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BitSet bitSet = new BitSet();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(bitSet.get(num))
                continue;
            bitSet.set(num);
            sb.append(num).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

}