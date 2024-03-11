import java.io.*;
import java.util.*;

public class Main{
	static int n;
	static boolean[] visited;
	static int[][] synergy;
	static int min = Integer.MAX_VALUE;
	static void comb(int cnt, int start) {
		if(cnt==n/2) {
			int a = 0;
			int b = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(visited[i]&&visited[j]) {
						a+=synergy[i][j];
					}
					else if(!visited[i]&&!visited[j]) {
						b+=synergy[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(a-b));
			
			return;
		}
		
		for(int i=start;i<n;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		synergy = new int[n][n];
		visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,1);
		
		System.out.println(min);
	}

}
