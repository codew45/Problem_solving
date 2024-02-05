import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			int[] snacks = new int[N];
			
			for(int i=0;i<N;i++) snacks[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					int sum = snacks[i]+snacks[j];
					if(sum<=M) max = Math.max(sum, max);
				}
			}
			if(max==Integer.MIN_VALUE) sb.append(-1).append("\n");
			else sb.append(max).append("\n");
		}
        System.out.println(sb);
	}

}
