import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int s : scoville){
            pq.add(s);
        }
        
        while(true){
            int first = pq.poll();
            
            if(first >= K) break;
            
            if(pq.isEmpty()) return -1;
            
            int second = pq.poll();
            int newScoville = first+second*2;
            
            pq.add(newScoville);
            answer++;
        }
        
        return answer;
    }
}