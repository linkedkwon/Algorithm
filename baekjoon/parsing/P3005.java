package baekjoon.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P3005 {

    static int r, c;
    static char[][] arr;
    static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        readIn();
        process();
        Collections.sort(words);
        System.out.println(words.get(0));
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for(int i = 0; i < r; i++)
            arr[i] = br.readLine().toCharArray();

        br.close();
    }

    static void process(){
        for(int i = 0; i < r; i++){
            String word = "";
            for(int j = 0; j < c; j++){
                if(arr[i][j] == '#'){
                    if(word.length() > 1)
                        words.add(word);
                    word = "";
                }else{
                    word += arr[i][j];
                }
            }
            if(word.length() > 1)
                words.add(word);
        }

        for(int i = 0; i < c; i++){
            String word = "";
            for(int j = 0; j < r; j++){
                if(arr[j][i] == '#'){
                    if(word.length() > 1)
                        words.add(word);
                    word = "";
                }else{
                    word += arr[j][i];
                }
            }
            if(word.length() > 1)
                words.add(word);
        }
    }

}