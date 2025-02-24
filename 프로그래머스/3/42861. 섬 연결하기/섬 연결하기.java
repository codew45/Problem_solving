import java.io.*;
import java.util.*;

class Solution {
    
    static int[] parent;
    
    static int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }
    
    static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY) return;
        else parent[rootY] = rootX;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        
        int totalCost = 0;
        int edgeCnt = 0;
        
        for(int[] cost : costs){
            int x = cost[0];
            int y = cost[1];
            int c = cost[2];
            
            if(find(x) != find(y)){
                union(x, y);
                totalCost += c;
                edgeCnt++;
            }
            
            if(edgeCnt == n-1) break;
        }
        
        return answer = totalCost;
    }
}