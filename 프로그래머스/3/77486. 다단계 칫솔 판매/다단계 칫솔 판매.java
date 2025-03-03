import java.io.*;
import java.util.*;

class Solution {
    static int[] answer;
    static int[] parent;
    
    static void backtracking(int idx, int profit){
        
        int tenPercent = profit/10;
        answer[idx] += profit;
        if(tenPercent < 1){
            return;
        }
        answer[idx] -= tenPercent;
        
        if(parent[idx]==-1) return;
        
        backtracking(parent[idx], tenPercent);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], i);
        }
        
        parent = new int[enroll.length];
        Arrays.fill(parent, -1);

        for(int i=0; i<referral.length; i++){
            if(referral[i].equals("-")) continue;
            
            parent[i] = map.get(referral[i]);
        }
        answer = new int[enroll.length];
        
        
        for(int i=0; i<amount.length; i++){
            int sellerIdx = map.get(seller[i]);
            backtracking( sellerIdx, amount[i]*100);
        }
        
        return answer;
    }
}