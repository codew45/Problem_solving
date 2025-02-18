import java.io.*;
import java.util.*;

class Solution {
    
    static int binarySearch(int x, int k, int d){
        int start = 0;
        int end = d;
        int maxJ = 0;
        
        long xSquare = (long) Math.pow(x, 2);
        long dSquare = (long) Math.pow(d, 2);
        
        while(start <= end){
            int mid = (start+end)/2;
            
            if( xSquare + Math.pow( mid*k, 2) <= dSquare ){
                maxJ = Math.max(maxJ, mid);
                
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return maxJ;
    }
    
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int x=0; x<=d; x+=k ){
            answer += binarySearch(x, k, d) + 1;
        }
        
        return answer;
    }
}