import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    
    int[] positions = new int[N];
    for(int i=0;i<N;i++){
        positions[i] = Integer.parseInt(br.readLine());
    }
    
    Arrays.sort(positions);
    
    int start = 1;
    int end = positions[N-1]-positions[0];
    int maxDist = 0;
    
    while(start<=end){
        int mid = (start+end)/2;
        
        int curPosition = positions[0];
        int installedCnt = 1;
        
        for(int i=1;i<N;i++){
            if(positions[i]-curPosition>=mid){
                installedCnt++;
                curPosition = positions[i];
            }
        }
        
        if(installedCnt>=C){
            maxDist = mid;
            start = mid+1;
        }else{
            end = mid-1;
        }
    }
    System.out.println(maxDist);
    
  }
}