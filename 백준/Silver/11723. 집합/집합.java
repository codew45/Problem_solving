import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer> set;
    static StringBuilder sb = new StringBuilder();
    
    static int isExist(int target){
        int start = 0;
        int end = set.size()-1;
        
        while(start<=end){
            int mid = (start+end)/2;
            
            if(set.get(mid) == target){
                return mid;
            }else if(set.get(mid)<target){
                start = mid+1;
            }else if(set.get(mid)>target){
                end = mid-1;
            }
        }
        return -999;
    }
    
    static void add(int x){
        if(isExist(x)!=-999) return;
        set.add(x);
    }
    
    static void remove(int x){
        int idx = isExist(x);
        if(idx==-999) return;
        
        set.remove(idx);
    }
    
    static void check(int x){
        sb.append(isExist(x)==-999 ? 0 : 1).append("\n");
    }
    
    static void toggle(int x){
        int idx = isExist(x);
        if(idx==-999){
            set.add(x);
        }else{
            set.remove(idx);
        }
    }
    
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int M = Integer.parseInt(br.readLine());
      set = new LinkedList<Integer>();
      
      for(int i=0;i<M;i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          String cmd = st.nextToken();
          
          if(st.hasMoreTokens()){
              int target = Integer.parseInt(st.nextToken());
          
              switch(cmd){
                  case "add":
                      add(target);
                      break;
                case "check":
                    check(target);
                    break;
                case "remove":
                    remove(target);
                    break;
                case "toggle":
                    toggle(target);
                    break;
            
              }
          }else{
              switch(cmd){
                  case "all":
                      set = new LinkedList<Integer>();
                      for(int j=1;j<=20;j++){
                          set.add(j);
                      }
                      break;
                case "empty":
                    set = new LinkedList<Integer>();
                    break;
              }
          }
          
      }
       System.out.println(sb);
    
  }
}