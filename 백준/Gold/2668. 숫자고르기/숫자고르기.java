import java.io.*;
import java.util.*;

public class Main {
    static int[] numbers;
    static boolean[] visited;
    static List<Integer> answer;
    
    static void dfs(int cur, int target){
        if(numbers[cur] == target){
            answer.add(target);
        }
        if(!visited[numbers[cur]]){
            visited[numbers[cur]] = true;
            dfs(numbers[cur], target);
            visited[numbers[cur]] = false;
        }
    }
    
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    numbers = new int[N+1];
    
    for(int i=1;i<=N;i++){
        numbers[i] = Integer.parseInt(br.readLine());
    }
    
    visited = new boolean[N+1];
    answer = new LinkedList<>();
    
    for(int i=1;i<=N;i++){
        visited[i] = true;
        dfs(i, i);
        visited[i] = false;
    }
    
    Collections.sort(answer);
    System.out.println(answer.size());
    for(int i:answer){
        System.out.println(i);
    }
    
  }
}