import java.io.*;
import java.util.*;

class Solution {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;
    
    static void dfs(int cur){
        
        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        
        for(int next: graph.get(cur)){
            if(visited[next]) continue;
            dfs(next);
            
            dp[cur][0] += dp[next][1];
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
    
    public int solution(int n, int[][] lighthouse) {
        
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<n-1; i++){
            int a = lighthouse[i][0] - 1;
            int b = lighthouse[i][1] - 1;
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dp = new int[n][2];
        visited = new boolean[n];
        visited[0] = true;
        dfs(0);
        
        return Math.min(dp[0][0], dp[0][1]);
    }
}