package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P11478 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();

        String str = br.readLine();
        int len = str.length();
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < len; j++){
                if(i + j > len)
                    break;
                set.add(str.substring(j, j + i));
            }
        }

        System.out.println(set.size());
        br.close();
    }

}