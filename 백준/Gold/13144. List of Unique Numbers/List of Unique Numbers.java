import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      
      int[] numbers = new int[N+1];
      int[] cnt = new int[100001];
      long answer = 0L;
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for(int i=1;i<=N;i++){
          numbers[i] = Integer.parseInt(st.nextToken());
      }
      
      int left = 1;
      int right = 1;
      
      while(left <= N){
          while(right <= N && cnt[numbers[right]]==0){
              cnt[numbers[right]]++;
              right++;
          }
          answer += right-left;
          cnt[numbers[left]]--;
          left++;
      }
      System.out.println(answer);
  }
}