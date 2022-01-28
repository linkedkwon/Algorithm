package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13460 {

    private static class Point{
        int rX, rY, bX, bY, cnt;

        public Point(int rX, int rY, int bX, int bY, int cnt) {
            this.rX = rX;
            this.rY = rY;
            this.bX = bX;
            this.bY = bY;
            this.cnt = cnt;
        }
    }

    private static int N, M, answer = -1;
    private static char[][] map;
    private static StringBuilder sb;
    private static HashSet<String> visited;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException{
        readIn();
        bfs();
        System.out.println(answer);
    }

    public static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        visited = new HashSet<>();
        map = new char[N][M];

        int rX = 0, rY =0, bX = 0, bY = 0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                char c = str.charAt(j);
                if(c == 'R'){
                    rX = i; rY = j;
                    map[i][j] = '.';
                    continue;
                }else if(c == 'B'){
                    bX = i; bY = j;
                    map[i][j] = '.';
                    continue;
                }
                map[i][j] = c;
            }
        }

        queue = new LinkedList<>();
        queue.offer(new Point(rX, rY, bX, bY, 0));
        sb.append(rX).append(rY).append(bX).append(bY);
        visited.add(sb.toString());

        br.close();
    }

    public static void bfs(){
        int[] x = {-1, 1, 0, 0}, y = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.cnt > 10)
                return;

            for(int d = 0; d < 4; d++){
                int rX = p.rX, rY = p.rY, bX = p.bX, bY = p.bY;
                boolean endR = true, endB = true, hasPutR = false, hasPutB = false;
                while(endR || endB){
                    char r = map[rX + x[d]][rY + y[d]];
                    if(r == '.'){
                        if(rX + x[d] == bX && rY + y[d] == bY){
                            endR = false;
                        }
                        else {
                            rX += x[d]; rY += y[d];
                        }
                    }else if(r == '#'){
                        endR = false;
                    }else if(r == 'O'){
                        hasPutR = true;
                        rX += x[d]; rY += y[d];
                    }

                    char b = map[bX + x[d]][bY + y[d]];
                    if(b == '.'){
                        if(bX + x[d] == rX && bY + y[d] == rY){
                            endB = false;
                        }
                        else {
                            bX += x[d]; bY += y[d];
                        }
                    }else if(b == '#'){
                        endB = false;
                    }else if(b == 'O'){
                        hasPutB = true;
                        bX += x[d]; bY += y[d];
                    }
                }

                if(hasPutB)
                    continue;
                if(hasPutR) {
                    answer = p.cnt + 1 > 10 ? -1 : p.cnt + 1;
                    return;
                }

                sb = new StringBuilder();
                sb.append(rX).append(rY).append(bX).append(bY);
                if(visited.contains(sb.toString()))
                    continue;

                queue.offer(new Point(rX, rY, bX, bY, p.cnt + 1));
                visited.add(sb.toString());
            }

        }

        return;
    }

}