package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P1744 {

    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] neg = new Integer[N], pos = new Integer[N];
        int dx = 0, dy = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0) pos[dx++] = num;
            else neg[dy++] = num;
        }

        Arrays.sort(neg, 0, dy);
        Arrays.sort(pos, 0, dx, Collections.reverseOrder());

        putInBracket(neg, dy);
        putInBracket(pos, dx);

        System.out.println(sum);
        br.close();
    }

    public static void putInBracket(Integer[] arr, int len){
        int i = 0;
        while(i < len){
            int n1 = arr[i++];
            if(i >= len){
                sum += n1;
                break;
            }
            int n2 = arr[i++];
            sum += n1 == 1 || n2 == 1 ? n1 + n2 : n1 * n2;
        }
    }
}