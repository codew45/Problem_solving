import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int[] arr = new int[N];
    
    for(int i=0;i<N;i++){
        arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    
    boolean[] isGood = new boolean[N];
    
    for(int i=0;i<N;i++){
        
        if(i>0 && arr[i-1]==arr[i] && isGood[i-1]){
            isGood[i] = true;
            continue;
        }
        
        for(int j=0; j<N; j++){
            if(i!=j){
                int target = arr[j];
                
                int start = 0;
                int end = N-1;
                
                while(start <= end){
                    int mid = (start+end)/2;
                    int sum = target+arr[mid];
                    
                    if(j!=mid && i!=mid && sum == arr[i]){
                        isGood[i] = true;
                        // System.out.println(arr[i] +" = "+arr[j]+" + "+arr[mid]);
                        break;
                    }
                    
                    else if(sum > arr[i]){
                        end = mid-1;
                    }else{
                        start = mid+1;
                    }
                }
            }
        }
    }
    
    int cnt = 0;
    for(int i=0;i<N;i++){
        if(isGood[i]) cnt++;
    }
    System.out.println(cnt);
  }
}