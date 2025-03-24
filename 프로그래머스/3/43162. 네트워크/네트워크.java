import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    
    static void bfs(int start, int[][] computers){
        Deque<Integer> q = new ArrayDeque<Integer>();
        visited[start] = true;
        q.add(start);
        
        answer++;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<computers[0].length; i++){
                if(visited[i]) continue;
                if(computers[cur][i]==0) continue;
                
                visited[i] = true;
                q.add(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) bfs(i, computers);
        }
        
        return answer;
    }
}