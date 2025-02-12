import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n+1];
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(destination);
        visited[destination] = true;
        dist[destination] = 0;
        
    
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next: graph.get(cur)){
                if(!visited[next] && dist[next] > dist[cur]+1){
                    dist[next] = dist[cur]+1;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        
        for(int i=0; i<sources.length; i++){            
            answer[i] = (dist[ sources[i] ]==Integer.MAX_VALUE? -1 : dist[ sources[i] ]);
        }
        
        return answer;
    }
}