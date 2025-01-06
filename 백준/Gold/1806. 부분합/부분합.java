import java.io.*;
import java.util.*;
public class Main {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    
    int[] numbers = new int[N];
    
    for(int i=0;i<N;i++){
        numbers[i] = Integer.parseInt(st.nextToken());
    }
    
    int start = 0;
    int end = 0;
    int sum = numbers[0];
    
    int minLength = Integer.MAX_VALUE;
    
    while(end<N){
        if(sum >= S){
            minLength = Math.min(minLength, end-start+1);
            sum -= numbers[start];
            start++;
        }else{
            if(end==N-1) break;
            end++;
            sum += numbers[end];
        }
    }
    
    System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
  }
}