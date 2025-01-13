import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] steps;
    
    static HashMap<Integer, Integer> ladders = new HashMap<Integer, Integer>();
    
    static void bfs(int start){
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=1;i<=6;i++){
                int next = cur+i;
                
                if(next==100){
                    steps[next] = steps[cur]+1;
                    visited[next] = true;
                    return;
                }
                
                if(next <= 100 && !visited[next]){
                    visited[next] = true;
                    steps[next] = steps[cur]+1;
                    
                    if(ladders.get(next) != null){
                        int ladderNext = ladders.get(next);
                        
                        if(!visited[ladderNext]){
                            steps[ladderNext] = steps[next];
                            visited[ladderNext] = true;
                        }else{
                            steps[ladderNext] = Math.min(steps[ladderNext], steps[next]);
                        }
                        
                        q.add(ladderNext);
                    }
                    
                    else {
                        q.add(next);
                    }
                    
                }
            }
        }
    }
    
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    visited = new boolean[101];
    steps = new int[101];
    
    
    for(int i=0;i<N+M;i++){
        st = new StringTokenizer(br.readLine());
        ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    
    bfs(1);
    System.out.println(steps[100]);
  }
}