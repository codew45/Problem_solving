import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for(int t : topping){
            right.put(t, right.getOrDefault(t, 0)+1);
        }
        
        for(int i=0; i<topping.length-1; i++){
            left.add(topping[i]);
            right.put(topping[i], right.get(topping[i]) - 1);
            
            if(right.get(topping[i]) == 0){
                right.remove(topping[i]);
            }
            
            if(left.size() == right.size()){
                answer++;
            }
        }
        
        return answer;
    }
}