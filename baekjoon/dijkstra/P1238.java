package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1238 {

    static class Node implements Comparable<Node>{
        int V, W;

        public Node(int v, int w) {
            V = v;
            W = w;
        }
        @Override
        public int compareTo(Node o) {
            return W - o.W;
        }
    }
    static int N, M, X, MAX;
    static int[] dist1, dist2;
    static ArrayList<Node>[] adj1, adj2;

    public static void main(String[] args) throws IOException{
        readIn();
        dijkstra(dist1, adj1);
        dijkstra(dist2, adj2);
        writeOut();
    }

    static void readIn() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        MAX = N * 101;

        adj1 = new ArrayList[N + 1]; adj2 = new ArrayList[N + 1];
        dist1 = new int[N + 1]; dist2 = new int[N + 1];
        for(int i = 1; i <= N; i++){
            adj1[i] = new ArrayList<>(); adj2[i] = new ArrayList<>();
            dist1[i] = MAX; dist2[i] = MAX;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken()),
                dz = Integer.parseInt(st.nextToken());
            adj1[dx].add(new Node(dy, dz));
            adj2[dy].add(new Node(dx, dz));
        }
        br.close();
    }

    static void dijkstra(int[] dist, ArrayList<Node>[] adj){
        PriorityQueue<Node> heap = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        heap.add(new Node(X, 0));
        dist[X] = 0;

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
    }

    static void writeOut(){
        int max = 0;
        for(int i = 1; i <= N; i++)
            max = Math.max(max, dist1[i] + dist2[i]);
        System.out.println(max);
    }

}