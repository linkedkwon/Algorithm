package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1753 {

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

    static int V, E, START, MAX;
    static int[] dist;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException{
        readIn();
        dijkstra();
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(br.readLine());

        MAX = 10 * V;
        dist = new int[V + 1];
        Arrays.fill(dist, MAX);

        adj = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken()),
                    dz = Integer.parseInt(st.nextToken());
            adj[dx].add(new Node(dy, dz));
        }
    }

    static void dijkstra(){
        PriorityQueue<Node> heap = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        heap.offer(new Node(START, 0));
        dist[START] = 0;
        while(!heap.isEmpty()){
            Node e = heap.poll();
            int dx = e.V;
            if(visited[dx]) continue;
            visited[dx] = true;

            for(Node obj : adj[dx]){
                if(dist[obj.V] > dist[dx] + obj.W){
                    dist[obj.V] = dist[dx] + obj.W;
                    heap.add(new Node(obj.V, dist[obj.V]));
                }
            }
        }
    }

    static void writeOut(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++)
            sb.append(dist[i] == MAX ? "INF" : dist[i]).append('\n');
        System.out.println(sb);
    }

}