import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] parent;
	static int[] depth;
	
	static void setTree(int cur, int curDepth, int curParent) {
		depth[cur] = curDepth;
		parent[cur] = curParent;
		for(int child:tree.get(cur)) {
			if(child==curParent) continue;
			setTree(child, curDepth+1, cur);
		}
	}
	static int findParent(int a, int b) {
		int depthA = depth[a];
		int depthB = depth[b];
		
		while(depthA>depthB) {
			a = parent[a];
			depthA--;
		}
		
		while(depthB>depthA) {
			b = parent[b];
			depthB--;
		}
		while(true) {
			if(a==b) return a;
			a = parent[a];
			b = parent[b];
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		depth = new int[N+1];
		parent = new int[N+1];
		
		for(int i=0;i<N+1;i++) tree.add(new ArrayList<Integer>());
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		setTree(1,1,0);
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(findParent(a,b)+"\n");
		}
		System.out.println(sb);
		
	}

}
