import java.io.*;
import java.util.*;

class Solution {
    public static String func(String str){
        
        Stack<Character> stack = new Stack<Character>();
        int cnt = 0;
        
        for(char c : str.toCharArray()){
            
            if( c == '1' ){
                stack.push(c);
            }else{
                
                if(stack.size()<2){
                    stack.push(c);
                    continue;
                }
                
                char first = stack.pop();
                char second = stack.pop();
                
                if(first == '1' && second == '1'){
                    cnt++;
                }else{
                    stack.push(second);
                    stack.push(first);
                    stack.push(c);
                }
            }
        }
        
        StringBuilder newStr = new StringBuilder();
        
        boolean zeroFlag = false;
        int tmpIdx = stack.size();
        int idx = 0;
        
        while(!stack.isEmpty()){
            char c = stack.pop();
            newStr.insert(0, c);
            
            if(!zeroFlag && c == '0'){
                idx = tmpIdx;
                zeroFlag = true;
            }
            tmpIdx--;
        }
        
        if(!zeroFlag){
            idx = 0;
        }

        for(int i=0; i<cnt; i++){
            newStr.insert(idx, "110");
        }
        
        return newStr.toString();
    }

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        
        for(int i=0; i<s.length; i++){
            answer[i] = func(s[i]);
        }
        
        return answer;
    }
}