package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P3190 {

    private static int[][] board;
    private static HashMap<Integer, Character> instruction;
    private static int dx = 1, dy = 1, direction = 4;

    public static void main(String[] args) throws IOException {

        inputStream();

        Deque<int[]> deq = new LinkedList<>();
        deq.add(new int[]{1, 1});

        int size = board.length - 1, t = 0;
        while (true) {
            char c = Optional.ofNullable(instruction.get(t)).orElseGet(() -> {
                return '0';
            });
            moveCordinate(c);
            t++;
            if (dx < 1 || dx > size || dy < 1 || dy > size)
                break;

            boolean collision = false;
            for(int[] arr : deq){
                if(arr[0] == dx && arr[1] == dy)
                    collision = true;
            }
            if(collision)
                break;

            deq.addFirst(new int[]{dx, dy});
            if(board[dx][dy] != 1)
                deq.pollLast();
            else
                board[dx][dy] = 0;
        }
        System.out.println(t);
    }

    public static void inputStream() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        instruction = new HashMap<>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            instruction.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        br.close();
    }

    public static void moveCordinate(char c) {
        if (c == '0') {
            switch (direction) {
                case 1: dx--; break;
                case 2: dx++; break;
                case 3: dy--; break;
                case 4: dy++; break;
            }
        } else {
            int x = c == 'D' ? 1 : -1, y = c == 'D' ? -1 : 1;
            int[] arr = c == 'D' ? new int[]{4, 3, 1, 2} : new int[]{3, 4, 2, 1};

            switch (direction) {
                case 1: dy += x; direction = arr[0]; break;
                case 2: dy += y; direction = arr[1]; break;
                case 3: dx += y; direction = arr[2]; break;
                case 4: dx += x; direction = arr[3]; break;
            }
        }
    }
}