import java.io.*;
import java.util.*;
public class Main {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    String input = br.readLine();
    boolean[] balls = new boolean[N];
    
    for(int i=0;i<input.length();i++){
        balls[i] = (input.charAt(i)=='R' ? true: false);
    }
    
    int lr = 0;
    int lb = 0;
    boolean standard = balls[0];
    int idx = 1;
    
    while(idx<N && standard==balls[idx]){
        idx++;
    }
    
    for(int i=idx;i<N;i++){
        if(balls[i]) lr++;
        else lb++;
    }
    
    int rr = 0;
    int rb = 0;
    standard = balls[N-1];
    idx = N-2;
    
    while(idx>=0 && standard==balls[idx]){
        idx--;
    }
    
    for(int i=idx;i>=0;i--){
        if(balls[i]) rr++;
        else rb++;
    }
    
    int leftMin = Math.min(lr, lb);
    int rightMin = Math.min(rr, rb);
    
    System.out.println(Math.min(leftMin, rightMin));
    
  }
}