import java.io.*;
import java.util.*;

public class Main{

	static int n;
	static int m;
	static int[] input;
	static boolean[] visited;
	
	static void comb(int cnt, int start) {
		if(cnt==m) {
			for(int i=0;i<n;i++) {
				if(visited[i]) System.out.print(input[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<n;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		input = new int[n];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		comb(0,0);
	}

}
