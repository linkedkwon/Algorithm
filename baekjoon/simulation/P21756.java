package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P21756 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++)
            list.add(i);

        while(list.size() != 1){
            int len = list.size(), dx = 0;
            for(int i = 0; i < len; i++){
                if(i % 2 == 0)
                    list.remove(dx++);
            }
        }

        System.out.println(list.get(0));
        br.close();
    }

}