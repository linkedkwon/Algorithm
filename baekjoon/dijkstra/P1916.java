package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916 {

    static class Node implements Comparable<Node>{
        int V, W;

        public Node(int v, int w) {
            V = v;
            W = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.W - o.W;
        }
    }
    static int N, M, START, END, MAX;
    static int[] dist;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException{
        readIn();
        dijkstra();
        System.out.println(dist[END]);
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); M = Integer.parseInt(br.readLine());

        MAX = 100000 * N;
        dist = new int[N + 1]; adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            dist[i] = MAX;
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken()),
                dz = Integer.parseInt(st.nextToken());
            adj[dx].add(new Node(dy, dz));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        START = Integer.parseInt(st.nextToken()); END = Integer.parseInt(st.nextToken());
        br.close();
    }

    static void dijkstra(){
        PriorityQueue<Node> heap = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        heap.add(new Node(START, 0));
        dist[START] = 0;

        while(!heap.isEmpty()){
            Node node = heap.poll();
            int dx = node.V;
            if(visited[dx]) continue;
            visited[dx] = true;

            for(Node obj : adj[dx]){
                if(dist[obj.V] > dist[dx] + obj.W){
                    dist[obj.V] = dist[dx] + obj.W;
                    heap.add(new Node(obj.V, dist[obj.V]));
                }
            }
        }
;    }

}