package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10825 {

    static class Grade implements Comparable<Grade>{
        String name;
        int language, english, math;

        public Grade(String name, int language, int english, int math) {
            this.name = name;
            this.language = language;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Grade o) {
            if(language != o.language) return o.language - language;
            if(english != o.english) return english - o.english;
            if(math != o.math) return o.math - math;
            return name.compareTo(o.name);
        }
    }

    static int N;
    static Grade[] grades;

    public static void main(String[] args) throws IOException{
        readIn();
        Arrays.sort(grades);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grades = new Grade[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            grades[i] = new Grade(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(Grade o : grades)
            sb.append(o.name).append('\n');

        System.out.println(sb);
    }

}