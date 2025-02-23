import java.io.*;
import java.util.*;
class Solution {
    
    static int[] teacherCnt;
    static int answer = Integer.MAX_VALUE;
    
    static void calcWaitingTime(int[][] reqs, int k){
        
        PriorityQueue<Integer>[] endTimes = new PriorityQueue[k];
        
        for(int i=0; i<k; i++){
            endTimes[i] = new PriorityQueue<Integer>();
            int tCnt = teacherCnt[i];
            
            for(int j=0; j<tCnt; j++){
                endTimes[i].add(0);
            }
        }
        int waitingTime = 0;
        
        for(int[] req : reqs){
            int start = req[0];
            int duration = req[1];
            int type = req[2] - 1;
            
            int prevEndTime = endTimes[type].poll();
            
            if(prevEndTime > start){
                waitingTime += prevEndTime - start;
                endTimes[type].add(prevEndTime + duration);
            }
            else if(prevEndTime < start){
                endTimes[type].add(start + duration);
            }
            else{
                endTimes[type].add(prevEndTime + duration);
            }
        }
        
        answer = Math.min(answer, waitingTime);
    }
    
    static void comb(int remainTeachers, int start, int k, int[][] reqs){
        if(remainTeachers == 0){
            calcWaitingTime(reqs, k);
            return;
        }
        
        for(int i=start; i<k; i++){
            teacherCnt[i]++;
            comb(remainTeachers-1, i, k, reqs);
            teacherCnt[i]--;
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        
        teacherCnt = new int[k];
        Arrays.fill(teacherCnt, 1);
        
        comb(n-k, 0, k, reqs);
        
        return answer;
    }
}