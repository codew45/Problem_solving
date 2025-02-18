import java.io.*;
import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dSquare = (long) d*d;
        
        for(int x=0; x<=d; x+=k ){
            long xSquare = (long)x*x;
            int maxY = (int) Math.sqrt( dSquare - xSquare )/k;
            
            answer += maxY+1;
            
        }
        
        return answer;
    }
}