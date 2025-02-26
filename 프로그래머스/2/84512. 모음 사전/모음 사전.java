import java.io.*;
import java.util.*;

class Solution {
    
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static String target;
    static int targetLen = 0;
    static int answer = 0;
    static int cnt = 0;
    
    static void backtracking(String cur){

        if(cur.length() > 5) return;
        
        if(cur.length() == targetLen){
            if(cur.equals(target)){
                answer = cnt;
                return;
            }
        }
        
        cnt++;
        
        for(char a: alphabet){
            backtracking(cur+a);
            if(answer > 0) return;
        }
    }
    
    public int solution(String word) {
    
        target = word;
        targetLen = word.length();
        
        backtracking("");
        
        return answer;
    }
}