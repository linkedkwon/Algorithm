package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13698 {

    static char[] cups = new char[4];
    static String read;

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        postProcess();
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        read = br.readLine();
        br.close();

        cups[0] = 's'; cups[3] = 'b';
    }

    static void process(){
        int len = read.length();
        for(int i = 0; i < len; i++){
            switch (read.charAt(i)){
                case 'A': swap(0, 1);break;
                case 'B': swap(0, 2);break;
                case 'C': swap(0, 3);break;
                case 'D': swap(1, 2);break;
                case 'E': swap(1, 3);break;
                case 'F': swap(2, 3);break;
            }
        }
    }

    static void swap(int i, int j){
        char tmp = cups[i];
        cups[i] = cups[j];
        cups[j] = tmp;
    }

    static void postProcess(){
        int small = 1, big = 1;
        for(int i = 0; i < 4; i++){
            if(cups[i] == 's')
                small += i;
            else if(cups[i] == 'b')
                big += i;
        }

        System.out.println(small + "\n" + big);
    }

}