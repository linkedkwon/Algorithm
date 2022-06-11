package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1551 {

    static int N, K;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        postProcess();
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        String[] tmp = br.readLine().split(",");
        for(int i = 0; i < N; i++)
            arr.add(Integer.parseInt(tmp[i]));

        br.close();
    }

    static void process(){
        for(int i = 0; i < K; i++)
            setArrByDistance();
    }

    static void setArrByDistance(){
        int len = arr.size();

        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 1; i < len; i++)
            tmp.add(arr.get(i) - arr.get(i - 1));

        arr = new ArrayList<>();
        for(Integer e : tmp)
            arr.add(e);
    }

    static void postProcess(){
        StringBuilder sb = new StringBuilder();
        int len = arr.size();
        for(int i = 0; i < len; i++)
            sb.append(arr.get(i)).append(',');

        len = sb.toString().length();
        String str = sb.substring(0, len - 1);
        System.out.println(str);
    }

}