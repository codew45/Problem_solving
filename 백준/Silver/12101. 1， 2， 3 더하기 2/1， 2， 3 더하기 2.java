import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        
        ArrayList<String>[] arr = new ArrayList[N+3];
        
        for(int i=0;i<N+3;i++) {
        	arr[i] = new ArrayList<>();
        }
        
        arr[1].add("1");
        arr[2].add("1+1");
        arr[2].add("2");
        arr[3].add("1+1+1");
        arr[3].add("1+2");
        arr[3].add("2+1");
        arr[3].add("3");
        
        for(int i=4;i<=N;i++) {
        	for(int j=1;j<=3;j++) {
        		for(String op : arr[i-j]) {
        			arr[i].add(op+"+"+j);
        		}
        	}
        }
        
        if(arr[N].size()<K) {
        	System.out.println(-1);
        }
        else {
			Collections.sort(arr[N]);
        	System.out.println(arr[N].get(K-1));
        }
        
    }
    
}
