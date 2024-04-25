import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        for(int i=0;i<queue1.length;i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        long total = sum1+sum2;
        long goal = total/2;
        
        int limit = 3*queue1.length-3;
        
        if(total%2!=0){
            return -1;
        }
        else{
            int cnt = 0;
        
            while(sum1!=goal){
                
                if(sum1 > sum2){
                    int tmp = q1.poll();
                    q2.add(tmp);
                    sum2 += tmp;
                    sum1 -= tmp;
                }else{
                    int tmp = q2.poll();
                    q1.add(tmp);
                    sum1 += tmp;
                    sum2 -= tmp;
                }
                cnt++;
                
                if(cnt>limit){
                    return -1;
                }
            }
            return cnt;
        }
    }
}