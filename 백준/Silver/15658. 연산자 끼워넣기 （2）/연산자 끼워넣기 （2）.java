import java.io.*;
import java.util.*;

public class Main {
	static int[] input;
	static int N;
	static int[] operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int cnt, int res) {
		if(cnt==N) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		for(int i=0;i<4;i++) {
			if(operator[i]==0) continue;
			
			operator[i]--;
			switch(i) {
			case 0:
				dfs(cnt+1, res+input[cnt]);
				break;
			
			case 1:
				dfs(cnt+1, res-input[cnt]);
				break;
				
			case 2:
				dfs(cnt+1, res*input[cnt]);
				break;
				
			case 3:
				dfs(cnt+1, res/input[cnt]);
				break;
			}
			operator[i]++;
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		operator = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) input[i]=Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) operator[i] = Integer.parseInt(st.nextToken());
		
		
		dfs(1,input[0]);
		System.out.println(max);
		System.out.println(min);
		
	}

}
