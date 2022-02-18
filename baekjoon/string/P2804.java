package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2804 {

    static String A, B;
    static char[][] arr;

    public static void main(String[] args) throws IOException{
        readIn();
        appendWord();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken(); B = st.nextToken();
        br.close();
    }

    static void appendWord(){
        arr = new char[B.length()][A.length()];
        int dx = 0, dy = 0;
        boolean flag = false;
        for(int i = 0; i < A.length(); i++){
            if(flag)
                break;
            for(int j = 0; j < B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    dx = i; dy = j; flag = true;
                    break;
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(i == dy) {
                arr[i] = A.toCharArray();
                continue;
            }
            for(int j = 0; j < arr[i].length; j++){
                if(j == dx)
                    arr[i][dx] = B.charAt(i);
                else
                    arr[i][j] = '.';
            }
        }
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++)
            sb.append(arr[i]).append('\n');
        System.out.println(sb);
    }

}