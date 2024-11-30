import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    int[][] positions = new int[K][2];
    
    for(int i=0;i<K;i++){
        st = new StringTokenizer(br.readLine());
        
        positions[i][0] = Integer.parseInt(st.nextToken());
        positions[i][1] = Integer.parseInt(st.nextToken());
        
    }
    
    int max = Integer.MIN_VALUE;
    
    for(int i=0;i<K;i++){
        for(int j=0;j<K;j++){
            int startX = positions[i][0];
            int startY = positions[j][1];
            
            int endX = startX+L;
            int endY = startY+L;
            int cnt = 0;
            
            for(int k=0;k<K;k++){
            
                int targetX = positions[k][0];
                int targetY = positions[k][1];
            
                if(targetX>=startX && targetX<=endX && targetY>=startY && targetY <= endY){
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
    }
    
    System.out.println(K-max);
  }
}