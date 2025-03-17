import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Deque<Integer> q = new ArrayDeque<Integer>();
        
        for(int i=0; i<players.length; i++){
            
            int size = q.size();
            for(int j=0; j<size; j++){
                int remain = q.poll() - 1;
                if(remain > 0) q.add(remain);
            }
            
            int need = (players[i] / m) - q.size();
            if(need > 0){
                answer += need;
                for(int j=0; j<need; j++){
                    q.add(k);
                }
            }
            
        }
        return answer;
    }
}