import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				list2.add(str);
			}
		}
		
		list2.sort(null);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(list2.size()).append('\n');
		for(int i=0;i<list2.size();i++) {
			sb.append(list2.get(i)).append('\n');
		}
		System.out.print(sb);
	}
}
