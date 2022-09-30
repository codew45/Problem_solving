import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		String s = "1";
		
		System.out.println(s.repeat((int)gcd(a,b)));
		
	}
	static long gcd(long a, long b) {
		while(b!=0) {
			long r = a % b;
			
			a = b;
			b = r;
		}
		return a;
	}

}
