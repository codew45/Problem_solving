import java.io.*;
import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    
    static void bfs(int n, int start, List<ArrayList<Integer>> graph, boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        int cnt = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            
            for(int next : graph.get(cur)){
                if(visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }
        
        answer = Math.min(answer, Math.abs(n - 2*cnt));
    }
    
    public int solution(int n, int[][] wires) {
        int len = wires.length;
        
        for(int i=0; i<len; i++){
            
            List<ArrayList<Integer>> graph = new ArrayList<>();
            for(int j=0; j<n+1; j++){
                graph.add(new ArrayList<>());
            }
            
            for(int j=0; j<len; j++){
                if(i==j) continue;
                
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            bfs(n, 1, graph, new boolean[n+1]);
            
        }
        
        return answer;
    }
}