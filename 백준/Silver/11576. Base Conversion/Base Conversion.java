import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			sum += (Integer.parseInt(st.nextToken()))*Math.pow(A, n-1-i);
			
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(sum!=0) {
			list.add(sum%B);
			sum /= B;
		}
		
		for(int i=list.size()-1;i>=0;i--) {
			System.out.print(list.get(i)+" ");
		}
		
	}
}
