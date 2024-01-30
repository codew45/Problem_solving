import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static boolean [] isSelected;
	static StringBuilder sb = new StringBuilder();
	static int [] numbers;
	
	public static void perm(int cnt) {
		if(cnt==M) {
			for(int n : numbers) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
            return;
		}
		for(int i=1;i<=N;i++) {
			if(!isSelected[i]) {
				numbers[cnt] = i;
				isSelected[i]=true;
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N+1];
		numbers = new int[M];
		
		perm(0);
		System.out.println(sb);
		
	}

}
