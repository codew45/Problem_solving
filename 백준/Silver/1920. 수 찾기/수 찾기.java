import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] arr1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr1);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			int in = Arrays.binarySearch(arr1, num);
			
			if(in>=0) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
			
		}
		System.out.println(sb);
		
	}
}
