import java.io.*;
import java.util.*;
public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());   
    int K = Integer.parseInt(st.nextToken());   
    
    int[] cnt = new int[100001];
    int[] numbers = new int[N];
    int max = 0;
    int start = 0;
    int end =0;
    
    st = new StringTokenizer(br.readLine());
    
    for(int i=0;i<N;i++){
        numbers[i] = Integer.parseInt(st.nextToken());
    }
    
    while(end<N){
        cnt[numbers[end]]++;
        while(cnt[numbers[end]] > K){
            cnt[numbers[start]]--;
            start++;
        }
        end++;
        max = Math.max(max, end-start);
    }
    System.out.println(max);
    
  }
}