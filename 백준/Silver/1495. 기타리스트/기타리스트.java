import java.io.*;
import java.util.*;
public class Main {
	static int n, s, m;
	static int[] v;
	
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
					if(!tmp.contains(small)) {
						tmp.add(small);
					}
				}
				
				if(big<=m) {
					if(!tmp.contains(big)) {
						tmp.add(big);
					}
				}
			}
			
			dp.get(i+1).addAll(tmp);
		}
		
		int maxVolume = Integer.MIN_VALUE;
		
		for(int data:dp.get(n)) {
			maxVolume = Math.max(maxVolume, data);
		}
		
		if(maxVolume == Integer.MIN_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(maxVolume);
		}
		
	}
}
