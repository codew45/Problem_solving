import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] input = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		
		for(int i=1;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				// j번쨰 수보다 i번째 수가 크고 
				// j번쨰까지의 최장 증가 수열에 i번째수를 포함한 게 더 길다면
				// i번째까지 포함시킨다
				if(input[i]>input[j]&&dp[i]<=dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int maxLen = 0;
		for(int i:dp) {
			maxLen = Math.max(maxLen, i);
		}
		System.out.println(maxLen);
	}

}
