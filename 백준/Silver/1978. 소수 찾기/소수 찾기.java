import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int cnt = 0;
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(is_prime(a)) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static boolean is_prime(int n) {
		int cnt = 0;
		if(n==1) return false;
		
		for(int i=2;i<=n;i++) {
			if(n%i==0) cnt++;
			if(cnt==2) return false;
		}
		return true;
	}

}
