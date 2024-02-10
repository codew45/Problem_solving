import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int K;
	static boolean[] isSelected;
	static int cntComb = 0;
	

	public static void combination(int cnt, int start) {
		if(cnt==K) {
			cntComb++;
			return;
		}
		
		for(int i=start;i<N;i++) {
			isSelected[cnt] = true;
			combination(cnt+1, i+1);
			isSelected[cnt] = false;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
			
		isSelected = new boolean[N];
			
		combination(0,0);
		
		System.out.println(cntComb);

	}

}
