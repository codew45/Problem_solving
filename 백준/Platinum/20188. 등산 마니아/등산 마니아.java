import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] numberOfNodes;
    
    static void dfs(int start){
        visited[start] = true;
        for(int next: tree.get(start)){
            if(visited[next]) continue;
            
            dfs(next);
            numberOfNodes[start] += numberOfNodes[next];
        }
        numberOfNodes[start]++;
    }
    
    static long nC2(int n){
        return (long)n*(n-1)/2;
    }
    
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine());
    numberOfNodes = new int[N+1];
    
    for(int i=0;i<N+1;i++){
        tree.add(new ArrayList<Integer>());
    }
    
    for(int i=0;i<N-1;i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        tree.get(start).add(end);
        tree.get(end).add(start);
    }
    
    visited = new boolean[N+1];
    dfs(1);
    
    long answer = 0;
    
    for(int i=2;i<=N;i++){
        int restNodeCnt = N-numberOfNodes[i];
        answer += nC2(N) - nC2(restNodeCnt);
    }
    
    System.out.println(answer);
  }
}