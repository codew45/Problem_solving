import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		dp[0] = 3;
		dp[1] = 7;
		for(int i=2;i<n;i++) {
			dp[i] = (dp[i-1]*2+dp[i-2])%9901;
			
		}
		System.out.println(dp[n-1]);
	}

}
