import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    Stack<Integer> stack = new Stack<>();
    int cnt = 0;
    
    for(int i=0;i<n;i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        while(!stack.isEmpty() && stack.peek() > y){
            stack.pop();
        }
        
        if(!stack.isEmpty() && stack.peek() == y){
            continue;
        }
        
        if(y > 0){
            cnt++;
            stack.push(y);
        }
        
    }
    
    System.out.println(cnt);
    
  }
}