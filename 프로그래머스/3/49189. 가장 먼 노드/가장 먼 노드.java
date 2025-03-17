import java.io.*;
import java.util.*;

class Solution {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    
    static void bfs(int start){
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph.get(cur)){
                if(visited[next]) continue;
                visited[next] = true;
                dist[next] = dist[cur]+1;
                q.add(next);
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0] - 1;
            int b = edge[i][1] - 1;
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        bfs(0);
        
        System.out.println(Arrays.toString(dist));
        
        int maxDist = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            if(dist[i] != Integer.MAX_VALUE && maxDist < dist[i]){
                maxDist = dist[i];
            }
        }
        
        for(int d:dist){
            if(d == maxDist) answer++;
        }
        
        return answer;
    }
}