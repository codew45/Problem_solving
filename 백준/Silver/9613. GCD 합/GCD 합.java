import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			long sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int j=0;j<n;j++) {
				
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int k=0;k<n-1;k++) {
				for(int l=k+1;l<n;l++) {
					sum += gcd(list.get(k),list.get(l));
				}
			}
			System.out.println(sum);
			
		}
	}
	static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			
			a = b;
			b = r;
		}
		return a;
	}

}
