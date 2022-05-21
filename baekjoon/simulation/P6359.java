package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6359 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
           int n = Integer.parseInt(br.readLine());
           boolean[] rooms = new boolean[n + 1];
           for(int i = 1; i <= n; i++){
               if(i % 2 != 0)
                   rooms[i] = true;
           }

           for(int i = 3; i <= n; i++){
               int mul = i;
               while(mul <= n){
                   rooms[mul] = rooms[mul] ? false : true;
                   mul += i;
               }
           }

           int cnt = 0;
           for(int i = 1; i <= n; i++){
               if(rooms[i])
                   cnt++;
           }
           sb.append(cnt).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}