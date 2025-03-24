import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 0;
        long right = 0;
        
        for(int t : times){
            right = Math.max(right, t);
        }
        right *= n;
        
        while(left <= right){
            long mid = (left+right)/2;
            long cnt = 0;
            
            for(int t : times){
                cnt += mid / t;
            }
            
            if(cnt >= n){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}