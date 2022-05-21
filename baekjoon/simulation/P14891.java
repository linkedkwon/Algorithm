package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P14891 {

    static int N;
    static boolean[] HAS_ROTATED;
    static Deque<Integer>[] GEARS = new LinkedList[4];

    public static void main(String[] args) throws IOException{
        preProcess();
        System.out.println(getGearScore());
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 4; i++){
            GEARS[i] = new LinkedList<>();
            String read = br.readLine();
            for(int j = 0; j < 8; j++)
                GEARS[i].offer(read.charAt(j) - '0');
        }

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            HAS_ROTATED = new boolean[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken());
            rotateGear(dx - 1, dy);
        }

        br.close();
    }

    static void rotateGear(int dx, int dy){
        HAS_ROTATED[dx] = true;
        int gear_dx = getGearNum(dx, -1), gear_dy = getGearNum(dx, 1);

        if(dx - 1 >= 0 && !HAS_ROTATED[dx - 1]){
            if(gear_dx != getGearNum(dx - 1, 1))
                rotateGear(dx - 1, dy * -1);
        }

        if(dx + 1 < 4 && !HAS_ROTATED[dx + 1]){
            if(gear_dy != getGearNum(dx + 1, -1))
                rotateGear(dx + 1, dy * -1);
        }

        if(dy == -1) GEARS[dx].offerLast(GEARS[dx].pollFirst());
        else GEARS[dx].offerFirst(GEARS[dx].pollLast());
    }

    static int getGearNum(int dx, int d){
        int i = 0, num = 0;
        for(int e : GEARS[dx]){
            if(d == 1 && i == 2) num = e;
            if(d == -1 && i == 6) num = e;
            i++;
        }
        return num;
    }

    static int getGearScore(){
        int sum = 0, dx = 1;
        for(int i = 0; i < 4; i++){
            if(GEARS[i].peekFirst() == 1)
                sum += dx;
            dx *= 2;
        }
        return sum;
    }

}