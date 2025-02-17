import java.io.*;
import java.util.*;

class Solution {
    static long maxSum = Integer.MIN_VALUE;
    
    static void maxSubarraySum(int[] arr){
        
        long curSum = 0;
        int start = 0;
        int end = 0;
        int tmpStart = 0;
        
        for(int i=0; i< arr.length; i++){
            curSum += arr[i];
            
            if(curSum > maxSum){
                maxSum = curSum;
                start = tmpStart;
                end = i;
            }
            
            if(curSum < 0){
                curSum = 0;
                tmpStart = i+1;
            }
            
        }
    }
    
    
    public long solution(int[] sequence) {
        long answer = 0;
        
        int len = sequence.length;
        
        int[] A = new int[len];
        int[] B = new int[len];
        
        for(int i=0; i<len; i+=2){
            A[i] = sequence[i]*(-1);
            B[i] = sequence[i];
        }
        
        for(int i=1; i<len; i+=2){
            A[i] = sequence[i];
            B[i] = sequence[i]*(-1);
        }
        
        maxSubarraySum(A);
        maxSubarraySum(B);

        return answer = maxSum;
    }
}