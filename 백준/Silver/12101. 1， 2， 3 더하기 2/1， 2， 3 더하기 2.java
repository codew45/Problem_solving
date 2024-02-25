import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		
		for(int i=0;i<n+3;i++) list.add(new ArrayList<>());
		
		list.get(1).add("1");
		list.get(2).add("1+1");
		list.get(2).add("2");
		list.get(3).add("1+1+1");
		list.get(3).add("1+2");
		list.get(3).add("2+1");
		list.get(3).add("3");
		
		for(int i=4;i<=n;i++) {
			for(int j=1;j<=3;j++) {
				for(String op:list.get(i-j)) {
					list.get(i).add(op+"+"+j);
				}
			}
		}
		
		if(list.get(n).size()<k) System.out.println(-1);
		else {
			Collections.sort(list.get(n));
			System.out.println(list.get(n).get(k-1));
		}
		
		
	}

}
