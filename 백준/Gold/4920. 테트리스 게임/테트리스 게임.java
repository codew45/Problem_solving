import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static long max;
    static int[][][] dir = {
            {
                {0, 0}, {-1, 0}, {-2, 0}, {-3, 0}
                
            },
            {{0, 0}, {0, -1}, {0, -2}, {0, -3}},
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
        
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
            
            {{0, 0}, {0, -1}, {-1, -1}, {-1, -2}},
            {{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}},
        
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {0, -1}, {0, -2}, {-1, -2}},
            {{0, 0}, {-1, 0}, {-2, 0}, {-2, 1}},
        
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 0}},
            {{0, 0}, {0, -1}, {0, -2}, {1, -1}},
            {{0, 0}, {-1, 0}, {-1, -1}, {-2, 0}},
            
        
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
            {{0, 0}, {0, -1}, {1, -1}, {1, 0}},
            {{0, 0}, {-1, -1}, {-1, 0}, {0, -1}},
            {{0, 0}, {-1, 0}, {-1, 1}, {0, 1}}
    };
    
    public static void rangeCheck(int x, int y){
        
        for(int i=0; i<20; i++){
            int sum = 0;
            
            int j=0;
            for(;j<4;j++){
                int nx = x + dir[i][j][0];
                int ny = y + dir[i][j][1];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                
                sum+= map[nx][ny];
            }
            
            if(j==4){
                max = Math.max(max, sum);
            }
        }
    }
    
    
  public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int t=1;
      while(true){
          N = Integer.parseInt(br.readLine().trim());
          if(N==0) break;
          
          max = Integer.MIN_VALUE;
          map = new int[N][N];
          
          for(int i=0;i<N;i++){
              StringTokenizer st = new StringTokenizer(br.readLine().trim());
              
              for(int j=0;j<N;j++){
                  map[i][j] = Integer.parseInt(st.nextToken());
              }
              
          }
          
        for(int x=0;x<N;x++){
            for(int y=0;y<N;y++){
                rangeCheck(x, y);
            }
        }
        
        sb.append(t).append(". ").append(max).append("\n");
        
        t++;
      }
      
      System.out.println(sb);
      
      
  }
}