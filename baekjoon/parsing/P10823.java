package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10823 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readIn();
        parseStr();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = br.readLine()) != null){
            sb.append(str);
        }
        br.close();
    }

    static void parseStr(){
        String[] arr = sb.toString().split(",");
        int len = arr.length, sum = 0;
        for(int i = 0; i < len; i++)
            sum += Integer.parseInt(arr[i]);
        System.out.println(sum);
    }

}