package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1924 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int i = 1; i < x; i++)
            y += arr[i];

        String str = "";
        switch (y % 7){
            case 0 : str = "SUN"; break;
            case 1 : str = "MON"; break;
            case 2 : str = "TUE"; break;
            case 3 : str = "WED"; break;
            case 4 : str = "THU"; break;
            case 5 : str = "FRI"; break;
            case 6 : str = "SAT"; break;
        }

        System.out.println(str);
        br.close();
    }

}