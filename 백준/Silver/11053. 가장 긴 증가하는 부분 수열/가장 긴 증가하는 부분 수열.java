import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		dp[0] = 0;
		lst.add(input[0]);
		
		int max = 0;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<lst.size();j++) {
				if(input[i]<=lst.get(j)) {
					dp[i] = j;
					lst.set(j, input[i]);
					break;
				}
				if(j==lst.size()-1) {
//					System.out.println(lst.get(lst.size()-1)+" "+input[i]+" "+j);
					dp[i] = j+1;
					lst.add(input[i]);
					break;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max+1);
//		System.out.println(Arrays.toString(lst.toArray()));
//		System.out.println(Arrays.toString(dp));
//		for(int i:lst) {
//			System.out.print(i+" ");
//		}
		

	}

}
