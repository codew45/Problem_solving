import java.io.*;
import java.util.*;
public class Main {
	final static long MOD = 1000000007;
	static long[][] fibo = {{1,1},{1,0}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		System.out.println(findFibo( N-1)[0][0]);
	}
	
	static long[][] findFibo(long n) {
		
		if(n<2) {
			return fibo;
		}
		
		long[][] tmp = findFibo(n/2);
		
		tmp = multiply(tmp, tmp);
		
		if(n%2==1) {
			tmp = multiply(tmp, fibo);
		}
		
		return tmp;
	}
	static long[][] multiply(long[][] a, long[][] b){
		long[][] tmp = new long[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					tmp[i][j] += a[i][k]*b[k][j];
					tmp[i][j] %= MOD;
				}
			}
		}
		return tmp;
	}
}
