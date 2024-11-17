import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[])throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int newScore = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());
    
    if(N==0){
        System.out.println(P>=1 ? 1 : -1);
    }
    
    if(N>0){
         LinkedList<Integer> ranking = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ranking.add(Integer.parseInt(st.nextToken()));
        }
        
        int rank = 1;
        for(int i=0;i<N;i++){
            int cur = ranking.get(i);
            
            if(cur>newScore){
                rank++;
            }else if(cur<newScore){
                break;
            }
        }
        
        if(ranking.get(N-1) == newScore && N==P){
            System.out.println(-1);
        }else{
             System.out.print(rank>P ? -1 : rank);
        }
        
    }

    
  }
}