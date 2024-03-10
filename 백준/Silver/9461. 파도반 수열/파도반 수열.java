import java.io.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		long[] dp = new long[101];
		
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = dp[5] = 2;
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int j=6;j<=n;j++) {
				dp[j] = dp[j-5]+dp[j-1];
			}
			System.out.println(dp[n]);
		}
	}

}
