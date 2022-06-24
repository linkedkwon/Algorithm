package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12756 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aA = Integer.parseInt(st.nextToken()), aHp = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bA = Integer.parseInt(st.nextToken()), bHp = Integer.parseInt(st.nextToken());

        while(aHp > 0 && bHp > 0){
            aHp -= bA;
            bHp -= aA;
        }

        if(aHp <= 0 && bHp <= 0)
            System.out.println("DRAW");
        else if(aHp <= 0 && bHp > 0)
            System.out.println("PLAYER B");
        else if(bHp <= 0 && aHp > 0)
            System.out.println("PLAYER A");

        br.close();
    }

}