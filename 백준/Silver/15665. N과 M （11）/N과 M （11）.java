import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	static int[] input;
	static int[] numbers;

	static StringBuilder sb = new StringBuilder();
	static HashSet<String> sequences = new HashSet<>();
	
	public static void perm(int cnt) {
		if(cnt==m) {
			String str = "";
			for(int i=0;i<m;i++) {
				str += numbers[i]+" ";
			}
			
			if(!sequences.contains(str)) {
				sequences.add(str);
				sb.append(str).append("\n");
			}
			
			return;
		}
		
		for(int i=0;i<n;i++) {
			numbers[cnt] = input[i];
			perm(cnt+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		input = new int[n];
		numbers = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		perm(0);
		
		System.out.println(sb);
	}

}
