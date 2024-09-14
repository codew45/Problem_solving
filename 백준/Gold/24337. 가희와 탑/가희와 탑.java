import java.io.*;
import java.util.*;
public class Main {
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      
      Deque<Integer> height = new ArrayDeque<>();
      
      for(int i=1;i<A;i++){
          height.add(i);
      }
      height.add(Math.max(A,B));
      for(int i=B-1;i>0;i--){
          height.add(i);
      }
      
      int len = height.size();
      
      StringBuilder sb = new StringBuilder();
      if(len>N){
           sb.append(-1);
      }else{
          sb.append(height.poll()+" ");
          for(int i=0;i<N-len;i++){
              sb.append(1+" ");
          }
          while(!height.isEmpty()){
              sb.append(height.poll()+" ");
          }
      }
      System.out.println(sb);
  }
}