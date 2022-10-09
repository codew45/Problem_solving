import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long twoCnt = get(N,2)-get(M,2)-get(N-M,2);
        long fiveCnt = get(N,5)-get(M,5)-get(N-M,5);
        
        System.out.println(Math.min(twoCnt, fiveCnt));
        
    }
    
    public static long get(int a, int b) {
    	long tmp = 0;
    	while(a>=b) {
    		tmp += a/b;
    		a /= b;
    	}
    	return tmp;
    	
    }
    
    
}