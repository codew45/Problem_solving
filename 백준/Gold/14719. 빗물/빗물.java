import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[])throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    
    int[] heights = new int[W];
    st = new StringTokenizer(br.readLine());
    
    int h = 0;
    int[] rain = new int[W];
    
    for(int i=0;i<W;i++){
        heights[i] = Integer.parseInt(st.nextToken());
        h = Math.max(h, heights[i]);
        rain[i] = h;
    }
    
    h = 0;
    int cntRain = 0;
    for(int i=W-1;i>=0;i--){
        h = Math.max(h, heights[i]);
        rain[i] = Math.min(rain[i], h);
        cntRain += rain[i] - heights[i];
    }
    System.out.println(cntRain);
  }
}