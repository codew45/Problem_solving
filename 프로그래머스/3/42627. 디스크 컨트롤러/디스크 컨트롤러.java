import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2)->(o1[0]-o2[0]));
        
        Queue<int[]> pq = new PriorityQueue<int[]>( (o1, o2)->(o1[1]-o2[1]) );
        
        int time = 0;
        int idx = 0;
        int len = jobs.length;
        
        while(idx < len || !pq.isEmpty()){
            
            while(idx < len && jobs[idx][0] <= time){
                pq.add(jobs[idx]);
                idx++;
            }
            
            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                int[] cur = pq.poll();
                time += cur[1];
                answer += time - cur[0];
            }
        }
        
        
        return answer / len;
    }
}