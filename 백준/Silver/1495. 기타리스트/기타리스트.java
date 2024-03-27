import java.io.*;
import java.util.*;

public class Main {
	static int n, s, m;
	static int[] v;
	static int max = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		v = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Set<Integer>> dp = new ArrayList<>();
		
		for(int i=0;i<=n;i++){
			dp.add(new HashSet<>());
		}
		
		Set<Integer> set = new HashSet<>();
		set.add(s);
		dp.get(0).addAll(set);
		
		for(int i=0;i<n;i++) {
			Set<Integer> tmp = new HashSet<>();
			
			for(int data:dp.get(i)) {
				int big = data+v[i];
				int small = data-v[i];
				
				if(small>=0) {
					tmp.add(small);
				}
				if(big<=m) {
					tmp.add(big);
				}
			}
			
			dp.get(i+1).addAll(tmp);
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int data:dp.get(n)) {
			max = Math.max(max, data);
		}
		
		if(max==Integer.MIN_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(max);
		}
		
		
	}

}





