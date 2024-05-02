import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int INF = Integer.MAX_VALUE;
        
        int[][] dp = new int[151][151];
        
        for(int i=0;i<151;i++){
            Arrays.fill(dp[i], INF);
        }
        
        int goal_alp = alp;
        int goal_cop = cop;
        
        int[][] new_problems = new int[problems.length+2][5];
        new_problems[0] = new int[]{0,0,1,0,1};
        new_problems[1] = new int[]{0,0,0,1,1};
        
        for(int i=0;i<problems.length;i++){
            goal_alp = Math.max(goal_alp, problems[i][0]);
            goal_cop = Math.max(goal_cop, problems[i][1]);
            
            new_problems[i+2] = problems[i];
        }
        
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= goal_alp; i++){
            for(int j = cop; j <= goal_cop; j++){
                if(i == goal_alp && j == goal_cop){
                    
                    return dp[i][j];
                }
                
                for(int k=0; k<new_problems.length; k++){
                    if(new_problems[k][0] > i || new_problems[k][1] > j){
                        continue;
                    }
                    
                    int new_alp = Math.min(i + new_problems[k][2], goal_alp);
                    int new_cop = Math.min(j + new_problems[k][3], goal_cop);
                    
                    if(dp[new_alp][new_cop] > dp[i][j] + new_problems[k][4]){
                       
                        dp[new_alp][new_cop] = dp[i][j] + new_problems[k][4];
                        
                    }
                }
            }
        }
        
        return answer;
    }
}