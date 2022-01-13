package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5586 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int joiCnt = 0, ioiCnt = 0;
        for(int i = 1; i < str.length() - 1; i++){
            char dx = str.charAt(i - 1);
            char dy = str.charAt(i);
            char dz = str.charAt(i + 1);

            if(dy == 'O'){
                if(dx == 'J' && dz == 'I')
                    joiCnt++;
                else if(dx == 'I' && dz == 'I')
                    ioiCnt++;
            }
        }

        System.out.println(joiCnt + "\n" + ioiCnt);
        br.close();
    }
}