import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int max = 0;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<=n;i++) {
			max = Math.max(max, dp[i]);
			
			int tmp = i+t[i];
			if(tmp<=n) {
				dp[tmp] = Math.max(dp[tmp], max+p[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
