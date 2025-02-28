import java.io.*;
import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int maxSheep = Integer.MIN_VALUE;
    
    static void dfs(int[] info, int curIdx, int sheep, int wolf, boolean[] canGo){
        
        boolean[] newCanGo = Arrays.copyOf(canGo, info.length);
        
        if(info[curIdx] == 0){
            sheep++;
            maxSheep = Math.max(sheep, maxSheep);
        }else{
            wolf++;
        }
        
        if(sheep <= wolf) return;
        
        newCanGo[curIdx] = false;
        for(int child : graph.get(curIdx)){
            newCanGo[child] = true;
        }
        
        for(int i=0; i<info.length; i++){
            if(newCanGo[i]){
                dfs(info, i, sheep, wolf, newCanGo);
            }
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        for(int i=0; i<info.length; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            
            graph.get(from).add(to);
        }
        
        boolean[] canGo = new boolean[info.length];
        for(int child : graph.get(0)) canGo[child] = true;
        
        dfs(info, 0, 0, 0, canGo);
        
        return answer = maxSheep;
    }
}