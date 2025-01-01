import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String input = br.readLine();
    String target = br.readLine();
    
    int inputLen = input.length();
    int targetLen = target.length();
    
    Stack<Character> stack = new Stack<>();
    
    for(int i=0; i<inputLen ;i++){
        
        char c = input.charAt(i);
        
        stack.push(c);
        boolean flag = true;
        
        if(stack.size() >= targetLen && stack.peek() == target.charAt(targetLen-1)){
            for(int j=0; j<targetLen ;j++){
                
                if(stack.get( stack.size()-1-j ) != target.charAt(targetLen-1-j)){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                for(int j=0;j<targetLen;j++) stack.pop();
            }
        }
    }
    
    StringBuilder sb = new StringBuilder();
    
    if(stack.isEmpty()){
        System.out.println("FRULA");
    }else{
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.reverse());
    }
    
    
  }
}