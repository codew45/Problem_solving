import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      
      int[][] dim = new int[N+1][2];
      
      for(int i=0; i<N; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          dim[i+1][0] = Integer.parseInt(st.nextToken());
          dim[i+1][1] = Integer.parseInt(st.nextToken());
      }
      
      int[][] dp = new int[N+1][N+1];
      
      for(int size = 2; size<=N; size++){
          for(int start = 1; start <= N - size + 1; start++){
              int end = start + size - 1;
              dp[start][end] = Integer.MAX_VALUE;
              
              for(int cursor = start; cursor<end; cursor++){
                  dp[start][end] = Math.min(dp[start][end],
                    dp[start][cursor]+dp[cursor+1][end] + dim[start][0]*dim[cursor][1]*dim[end][1]
                  );
              }
          }
      }
      
      System.out.println(dp[1][N]);



  }
}