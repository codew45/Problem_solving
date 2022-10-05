import java.io.*;
import java.util.*;
public class Main {
	public static boolean[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N+1];
        
        get_prime();
		
		for(int i=M;i<=N;i++) {
			if(!arr[i]) System.out.println(i);
		}
		
	}
	
	public static void get_prime() {
		arr[0] = arr[1] = true;
		
		for(int i=2;i<=Math.sqrt(arr.length);i++) {
			if(arr[i]) continue;
			for(int j=i*i;j<arr.length;j+=i) arr[j] = true;
		}
	}
}
