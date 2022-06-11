import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int cnt = 1, max = -1, max_idx=0;
        
        for(int i=0;i<N-1;i++) {
        	if(arr[i]==arr[i+1]) cnt++;
        	else cnt = 1;
        	if(cnt>max) {
        		max = cnt;
        		max_idx = i;
        	}
        }
        System.out.println(arr[max_idx]);
    }
}