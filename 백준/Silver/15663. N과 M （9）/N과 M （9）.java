import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n;
	static int m;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;
	static TreeSet<String> set = new TreeSet<>();
	static StringBuilder sb = new StringBuilder();
	
	static void perm(int cnt) {
		if(cnt==m) {
			String str = "";
			for(int i=0;i<numbers.length;i++) {
				str+= numbers[i];
				str+= " ";
			}
			if(!set.contains(str)) {
				set.add(str);
				sb.append(str).append("\n");
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = input[i];
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		isSelected = new boolean[n];
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
