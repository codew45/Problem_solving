import java.io.*;
import java.util.*;

public class Main {
    
    static class Node{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      ArrayList<ArrayList<Node>> graph = new ArrayList<>();
      for(int i=0;i<N+1;i++){
          graph.add(new ArrayList<>());
      }
      
      for(int i=0;i<M;i++){
          st = new StringTokenizer(br.readLine());
          int s = Integer.parseInt(st.nextToken());
          int e = Integer.parseInt(st.nextToken());
          int c = Integer.parseInt(st.nextToken());
          
          graph.get(s).add(new Node(e, c));
          graph.get(e).add(new Node(s, c));
      }
      
      boolean[] visited = new boolean[N+1];
      int[] dist = new int[N+1];
      Arrays.fill(dist, Integer.MAX_VALUE);
      
      dist[1] = 0;
      PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.cost, o2.cost));
      pq.add(new Node(1, 0));
      
      while(!pq.isEmpty()){
          int cur = pq.poll().idx;
          
          if(visited[cur]) continue;
          visited[cur] = true;
          
          for(Node next: graph.get(cur)){
             if(dist[next.idx]>dist[cur]+next.cost){
                 dist[next.idx] = dist[cur]+next.cost;
                 pq.add(new Node(next.idx, dist[next.idx]));
             }
              
          }
      }
      System.out.println(dist[N]);
      
      
  }
}