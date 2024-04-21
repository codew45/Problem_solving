import java.io.*;
import java.math.BigInteger;
/*
 * 1 : 1
 * 2 : 1(세로둘)+1(가로둘)+1(큰네모하나
 * 3 : 1(세로셋)+1(
 * f(n) = f(n-1) + 2*f(n-2)
 * 
 * 
 */
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BigInteger[] dp = new BigInteger[251];
		
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		for(int i=2;i<251;i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
		}

		String input;
		while((input=br.readLine())!=null) {
			int n = Integer.parseInt(input);
			
			sb.append(dp[n].toString()+"\n");
		}
		System.out.println(sb);

	}

}
