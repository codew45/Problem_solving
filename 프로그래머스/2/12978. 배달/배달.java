import java.io.*;
import java.util.*;
class Solution {
    
    class Node{
        int idx;
        int curDist;
        public Node(int idx, int curDist){
            this.idx = idx;
            this.curDist = curDist;
        }
        
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        List<ArrayList<Node>> graph = new ArrayList<>();
        
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<Node>());
        }
        
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int d = road[i][2];
            
            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.curDist - o2.curDist);

        boolean[] visited = new boolean[N+1];
        visited[0] = visited[1] = true;
        dist[0] = dist[1] = 0;
        
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visited[cur.idx] = true;
            
            for(Node next: graph.get(cur.idx)){
                
                visited[next.idx] = true;
                if(dist[next.idx] > dist[cur.idx]+next.curDist){
                    dist[next.idx] = dist[cur.idx]+next.curDist;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        
        // System.out.println(Arrays.toString(dist));
        
        for(int i=1; i<N+1; i++){
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
}