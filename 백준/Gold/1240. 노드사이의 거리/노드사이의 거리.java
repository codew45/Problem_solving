import java.io.*;
import java.util.*;
public class Main{
	static List<ArrayList<Node>> tree = new ArrayList<>();
	static int N;
	static int answer;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N+1;i++) tree.add(new ArrayList<>()); 
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			tree.get(a).add(new Node(b,d));
			tree.get(b).add(new Node(a,d));
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v = new boolean[N+1];
			answer = 0;
			dfs(a,b,0);
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int start, int target, int cost) {
		if(start==target) {
			answer = cost;
			return;
		}
		v[start] = true;
		for(int i=0;i<tree.get(start).size();i++) {
			if(!v[tree.get(start).get(i).to]) {
				dfs(tree.get(start).get(i).to,target,cost+tree.get(start).get(i).dist);
			}
		}
		
	}
	
	static class Node{
		int to;
		int dist;
		Node(int to, int dist){
			this.to = to;
			this.dist = dist;
		}
	}
	

}
