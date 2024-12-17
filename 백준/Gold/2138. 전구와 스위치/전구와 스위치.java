import java.io.*;
import java.util.*;

public class Main {
    
    static int[] target;
    static int N;
    
    public static int[] push(int[] arr, int idx){
        
        for(int i=idx-1;i<=idx+1;i++){
            if(i>=0 && i<N){
                arr[i] = 1-arr[i];
            }
        }
        return arr;
    }
    
    public static int func(int[] arr){
        
        int cnt = 0;
        
        for(int i=1;i<N;i++){
            if(arr[i-1] != target[i-1]){
                cnt++;
                arr = push(arr, i);
            }
        }
        
        for(int i=0;i<N;i++){
            if(arr[i]!=target[i]){
                return -1;
            }
        }
        return cnt;
    }
    
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    
    int[] first = new int[N];
    int[] second = new int[N];
    target = new int[N];
    
    String in = br.readLine();
        for (int i = 0; i < N; i++) {
            first[i] = in.charAt(i) - '0';
            second[i] = first[i];
        }

        String t = br.readLine();
        for (int i = 0; i < N; i++) {
            target[i] = t.charAt(i) - '0';
        }
    
    int firstCnt = func(first);
    
    second = push(second, 0);
    
    // System.out.println(Arrays.toString(first));
    
    int secondCnt = func(second);
   if (firstCnt == -1 && secondCnt == -1) {
            System.out.println(-1);
        } else if (firstCnt == -1) {
            System.out.println(secondCnt + 1);
        } else if (secondCnt == -1) {
            System.out.println(firstCnt);
        } else {
            System.out.println(Math.min(firstCnt, secondCnt + 1));
        }
    
  }
}