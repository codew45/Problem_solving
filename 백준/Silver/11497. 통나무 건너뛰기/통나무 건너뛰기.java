import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> inputs = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				inputs.add(Integer.parseInt(st.nextToken()));
			}
			
			int[] list = new int[n];
			
			for(int i=0;i<n/2;i++) {
				list[i] = inputs.poll();
				list[n-1-i] = inputs.poll();
			}
			
			if(n%2!=0) {
				list[n/2] = inputs.poll();
			}
			
			int ans = Integer.MIN_VALUE;
			
			for(int i=0;i<n-1;i++) {
				if(Math.abs(list[i]-list[i+1])>ans) {
					ans = Math.abs(list[i]-list[i+1]);
				}
			}
			System.out.println(ans);
		}
		
		
	}

}
