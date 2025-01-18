import java.io.*;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line>{
        int start;
        int end;
        public Line(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Line o){
            if(this.end == o.end) return this.end - o.end;
            return this.start - o.start;
        }
    }
    
  public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      
      PriorityQueue<Line> pq = new PriorityQueue<Line>();
      
      for(int i=0;i<N;i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          
          int s = Integer.parseInt(st.nextToken());
          int e = Integer.parseInt(st.nextToken());
          
          pq.add(new Line(s,e));
      }
      
      Line first = pq.poll();
      int len = first.end - first.start;
      int s = first.start;
      int e = first.end;
      
      while(!pq.isEmpty()){
          Line next = pq.poll();
          
          int ns = next.start;
          int ne = next.end;
          
          if(e < ns){
              len += ne - ns;
              s = ns;
              e = ne;
          }
          else if(s <= ns){
              if(e < ne){
                len += ne - e;
                e = ne;
              }
          }
      }
      
      System.out.println(len);
      
  }
}