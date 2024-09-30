import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N;
    static int[] operators;
    static StringBuilder sb = new StringBuilder();
    
    static void perm(int cnt){
        if(cnt==N-1){
            makeExpression();
            return;
        }
        
        for(int i=0;i<3;i++){
            operators[cnt] = i;
            perm(cnt+1);
        }
    }
    
    static void makeExpression(){
        StringBuilder expression = new StringBuilder();
        expression.append(1);
        
        int result = 0;
        int tmp = 1;
        int sign = 1;
        
        for(int i=0;i<N-1;i++){
            switch(operators[i]){
                case 0:
                	tmp = tmp*10 + (i+2);
                	expression.append(" ").append(i+2);
                    break;
                case 1:
                	result += sign*tmp;
                	tmp = i+2;
                	sign = 1;
                	expression.append("+").append(i+2);
                    break;
                case 2:
                	result += sign*tmp;
                	tmp = i+2;
                	sign = -1;
                	expression.append("-").append(i+2);
                    break;
            }
        }
        
        result += sign*tmp;
        
        if(result==0){
            sb.append(expression).append("\n");
        }
    }
    
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    int T = Integer.parseInt(br.readLine());
    
    for(int t=0;t<T;t++){
        N = Integer.parseInt(br.readLine());
        operators = new int[N-1];
        
        perm(0);
        sb.append("\n");
    }
    
    System.out.println(sb);
  }
}