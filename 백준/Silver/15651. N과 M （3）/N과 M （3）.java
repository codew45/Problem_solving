import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[] sequence;
	static StringBuilder sb = new StringBuilder();
	
	static void perm(int cnt) {
		if(cnt==M) {
			for(int i:sequence) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			sequence[cnt] = i+1;
			perm(cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sequence = new int[M];
		
		perm(0);
		System.out.println(sb);
	}

}
