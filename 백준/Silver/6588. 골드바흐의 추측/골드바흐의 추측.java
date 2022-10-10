import java.io.*;
import java.util.*;
public class Main {
	static boolean[] prime = new boolean[1000001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		get_prime();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			int a = make_n(n);
			if(a==-1) {
				sb.append("Goldbach's conjecture is wrong.\n");
				
			}
			else {
				sb.append(n+" = "+a+" + ").append(n-a).append('\n');
			}
		}
		System.out.print(sb);

	}
	
	static int make_n(int n) {
		for(int i=1;i<=n/2;i++) {
			int a = i;
			int b = n-a;
			if(prime[a]==false&&prime[b]==false) return a;
		}
		return -1;
	}
	
	static void get_prime() {
		prime[0] = prime[1] = true;
		
		for(int i=2;i<=Math.sqrt(prime.length);i++) {
			if(prime[i]) continue;
			
			for(int j=i*i;j<prime.length;j+=i) {
				prime[j] = true;
			}
		}
	}

}
