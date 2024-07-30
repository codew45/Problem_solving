import java.io.*;
import java.util.*;
public class Main {
	

	static int N;
	static int L;
	static int R;
	static int X;
	static int[] level;
	static int result = 0;
	static boolean[] selected;
	
	public static void backtracking(int idx, int cnt, int sum, int min, int max) {
		if(cnt>=2) {
			if(L<=sum && R>=sum && max-min>=X) {
				result++;
			}
		}
		
		for(int i=idx;i<N;i++) {
			backtracking(i+1, cnt+1, sum+level[i], Math.min(min, level[i]), Math.max(max, level[i]));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		level = new int[N];
		selected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			level[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(level);
		
		backtracking(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		System.out.println(result);
	}

}
