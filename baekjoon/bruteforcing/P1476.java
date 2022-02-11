package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1476 {

    static int E, S, M;

    public static void main(String[] args) throws IOException{
        readIn();
        searchYear();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void searchYear(){
        int de = 1, ds = 1, dm = 1, year = 1;
        while(!(de == E && ds == S && dm == M)){
            de = ++de % 16 == 0 ? 1 : de;
            ds = ++ds % 29 == 0 ? 1 : ds;
            dm = ++dm % 20 == 0 ? 1 : dm;

            year++;
        }
        System.out.println(year);
    }

}