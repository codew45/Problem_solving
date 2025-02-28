import java.io.*;
import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static int[] numbers;
    static boolean[] visited;
    
    static void perm(int cnt, int N){
        
        if(cnt == N){
            for(int n : numbers){
                sb.append(n+" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            numbers[cnt] = i+1;
            perm(cnt+1, N);
            visited[i] = false;
        }
    }
    
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    numbers = new int[N];
    visited = new boolean[N];
    
    perm(0, N);
    
    System.out.println(sb);
    
  }
}